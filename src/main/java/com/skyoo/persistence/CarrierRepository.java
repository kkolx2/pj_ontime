package com.skyoo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skyoo.domain.CarrierVO;

public interface CarrierRepository extends JpaRepository<CarrierVO, String> {

}