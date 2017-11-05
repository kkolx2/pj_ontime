package com.skyoo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skyoo.domain.OriginVO;

public interface OriginRepository extends JpaRepository<OriginVO, String> {

}