package com.skyoo.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skyoo.vo.PageMaker;
import com.skyoo.vo.PageVO;
import com.querydsl.core.types.Predicate;
import com.skyoo.domain.AirportVO;
import com.skyoo.domain.CarrierVO;
import com.skyoo.domain.OntimeVO;
import com.skyoo.persistence.AirportRepository;
import com.skyoo.persistence.CarrierRepository;
import com.skyoo.persistence.OntimeRepository;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/ontime")
@Log
public class OntimeController {

	@Inject
	OntimeRepository ontimeRepo;
	
	@Inject
	CarrierRepository carrierRepo;
	
	@Inject
	AirportRepository airportRepo;
	
	@GetMapping("/list")
	@Transactional
	public String list(@ModelAttribute("pageVO") PageVO vo,Model model){
		log.info("########### list called... ############");
		Pageable pageable = vo.makePageable(0, "ono");
		Predicate predicate = ontimeRepo.makePredicate(vo.getType(), vo.getKeyword());
		
		Page<OntimeVO> result = ontimeRepo.findAll(predicate, pageable);
		
		log.info(""+ pageable);
		log.info(""+result);
		
		log.info("TOTAL PAGE NUMBER: " + result.getTotalPages());
		
		
		model.addAttribute("pageMaker", new PageMaker(result));
		
		List<OntimeVO> ontimes = ontimeRepo.findAll();

		

		model.addAttribute("ontimes",ontimes);

		
		return "thymeleaf/ontime/list";
	}
	
	@GetMapping("/register")
	public String registerGET(){
		
		return "thymeleaf/ontime/register";
	}
	
	
	@GetMapping("/registerOntime")
	public String registerOntimeGET(@ModelAttribute("ontime")OntimeVO ontime,
										 @ModelAttribute("airport")AirportVO airport,
										 @ModelAttribute("carrier")CarrierVO carrier,Model model){
		log.info("########## registerGET called... ###########");
		
		List<AirportVO> airports = airportRepo.findAll();
		List<CarrierVO> carriers = carrierRepo.findAll();
		
		model.addAttribute("airports",airports);
		model.addAttribute("carriers",carriers);
		return "thymeleaf/ontime/registerOntime";
	}
	
	@PostMapping("/registerOntime")
	public String registerOntimePOST(@ModelAttribute("ontime")OntimeVO ontime,@ModelAttribute("airport")AirportVO airport,
			 @ModelAttribute("carrier")CarrierVO carrier,RedirectAttributes rttr){
		log.info("########## registerPOST called... ###########");
		System.out.println(ontime);
		AirportVO a = new AirportVO();
		CarrierVO c = new CarrierVO();
		String aiata = ontime.getDest();
		String cCode = ontime.getUcarrier();
		a.iata=aiata;
		c.setCode(cCode);
		ontime.setIata(a);
		ontime.setCode(c);
		ontimeRepo.save(ontime);
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/ontime/list";
	}
	@GetMapping("/registerCarrier")
	public String registerCarrierGET(@ModelAttribute("carrier")CarrierVO carrier,Model model){
		log.info("########## registerGET called... ###########");
		
		List<CarrierVO> carriers = carrierRepo.findAll();
		
		model.addAttribute("carriers",carriers);
		return "thymeleaf/ontime/registerCarrier";
	}
	
	@PostMapping("/registerCarrier")
	public String registerCarrierPOST(@ModelAttribute("carrier")CarrierVO carrier,RedirectAttributes rttr){
		log.info("########## registerPOST called... ###########");
		carrierRepo.save(carrier);
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/ontime/list";
	}
	@GetMapping("/registerAirport")
	public String registerAirportGET(@ModelAttribute("airport")AirportVO airport,Model model){
		log.info("########## registerGET called... ###########");
		
		List<AirportVO> airports = airportRepo.findAll();
		
		model.addAttribute("airports",airports);
		return "thymeleaf/ontime/registerAirport";
	}
	
	@PostMapping("/registerAirport")
	public String registerAirportPOST(@ModelAttribute("airport")AirportVO airport,RedirectAttributes rttr){
		log.info("########## registerPOST called... ###########");
		airportRepo.save(airport);
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/ontime/list";
	}
	@GetMapping("/view")
	public String view(Integer ono, @ModelAttribute("pageVO") PageVO vo, Model model){
		
		log.info("ONO: "+ ono);
		
		ontimeRepo.findById(ono).ifPresent(qOntime -> model.addAttribute("ontime", qOntime));
		
		return "thymeleaf/ontime/view";
	}
	@GetMapping("/modify")
	public String modify(Integer ono, @ModelAttribute("pageVO") PageVO vo, Model model){
		
		log.info("Modify ONO: "+ ono);
		
		ontimeRepo.findById(ono).ifPresent(qOntime -> model.addAttribute("ontime", qOntime));
		
		return "thymeleaf/ontime/modify";
	}
	@PostMapping("/modify")
	public String modifyPost(OntimeVO ontime, PageVO vo, RedirectAttributes rttr ){
		
		log.info("Modify ontime: " + ontime);
		
		
		ontimeRepo.findById(ontime.getOno()).ifPresent( origin ->{
		 
			origin.setDest(ontime.getDest());
			origin.setDistance(ontime.getDistance());
			
			ontimeRepo.save(origin);
			rttr.addFlashAttribute("msg", "success");
			rttr.addAttribute("bno", origin.getOno());
		});
		
		//페이징과 검색했던 결과로 이동하는 경우 
		rttr.addAttribute("page", vo.getPage());
		rttr.addAttribute("size", vo.getSize());
		rttr.addAttribute("type", vo.getType());
		rttr.addAttribute("keyword", vo.getKeyword());

		return "redirect:/boards/view";
	}
	@PostMapping("/delete")
	public String delete(Integer ono, PageVO vo, RedirectAttributes rttr ){
		
		log.info("DELETE oNo: " + ono);
		
		ontimeRepo.deleteById(ono);
		
		rttr.addFlashAttribute("msg", "success");

		//페이징과 검색했던 결과로 이동하는 경우 
		rttr.addAttribute("page", vo.getPage());
		rttr.addAttribute("size", vo.getSize());
		rttr.addAttribute("type", vo.getType());
		rttr.addAttribute("keyword", vo.getKeyword());

		return "redirect:/ontime/list";
	}
}
