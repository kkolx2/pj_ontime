package com.skyoo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.skyoo.domain.OntimeVO;
import com.skyoo.domain.QOntimeVO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public interface OntimeRepository extends JpaRepository<OntimeVO, Integer>,QuerydslPredicateExecutor<OntimeVO> {


		
		//Java 8 interface logic available => default keyword add.
		public default Predicate makePredicate(String type, String keyword){
			
			BooleanBuilder builder = new BooleanBuilder();
			
			QOntimeVO qOntime = QOntimeVO.ontimeVO;
			
			builder.and(qOntime.ono.gt(0));
			
			if(type == null){
				return builder;
			}
			
			switch(type){
			case "or":
				builder.and(qOntime.origin.like("%" + keyword +"%"));
				break;
			case "de":
				builder.and(qOntime.dest.like("%" + keyword +"%"));
				break;
			case "ia":
				builder.and(qOntime.iata.airport.like("%" + keyword +"%"));
				break;
			case "ic":
				builder.and(qOntime.iata.city.like("%" + keyword +"%"));
				break;
			case "cd":
				builder.and(qOntime.code.description.like("%" + keyword +"%"));
				break;
			}
			
			return builder;
		}
}