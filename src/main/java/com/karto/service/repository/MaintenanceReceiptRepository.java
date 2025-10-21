package com.karto.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karto.service.model.MaintenanceReceipt;

@Repository
public interface MaintenanceReceiptRepository extends JpaRepository<MaintenanceReceipt, Integer> {

}
