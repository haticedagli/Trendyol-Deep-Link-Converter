package com.trendyol.deeplinkconverter.repository;

import com.trendyol.deeplinkconverter.entity.LinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConverterRepository extends JpaRepository<LinkEntity, Long> {

}
