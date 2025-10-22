package com.karto.service.repository;

import com.karto.service.model.MaintenanceReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceReceiptRepository extends JpaRepository<MaintenanceReceipt, Integer> {}
