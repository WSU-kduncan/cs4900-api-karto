package com.karto.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karto.service.model.MaintenanceItemDetail;
import com.karto.service.model.composite.MaintenanceItemDetailId;

@Repository
public interface MaintenanceItemDetailRepostiry extends JpaRepository<MaintenanceItemDetail, MaintenanceItemDetailId> {

}
