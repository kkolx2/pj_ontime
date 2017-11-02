package com.skyoo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skyoo.domain.AirportVO;

public interface AirportRepository extends JpaRepository<AirportVO, String> {

}