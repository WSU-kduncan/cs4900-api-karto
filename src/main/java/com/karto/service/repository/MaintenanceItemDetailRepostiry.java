package com.karto.service.repository;

import com.karto.service.model.MaintenanceItemDetail;
import com.karto.service.model.composite.MaintenanceItemDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceItemDetailRepostiry
    extends JpaRepository<MaintenanceItemDetail, MaintenanceItemDetailId> {}
