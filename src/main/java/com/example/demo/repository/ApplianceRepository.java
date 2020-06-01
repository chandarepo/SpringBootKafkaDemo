package com.example.demo.repository;


import com.example.demo.bean.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ApplianceRepository extends JpaRepository<Appliance, ApplianceIdentity> {
    List<Appliance> findByApplianceIdentityModelLike(String model);
    List<Appliance> findByApplianceIdentitySerialNumberLike(String srNum);
    List<Appliance> findByApplianceIdentityBrandLike(String brand);
    List<Appliance> findByStatusLike(ApplicanceStatus status);
    List<Appliance> findByBoughtDate(Date date);
    Appliance findByApplianceIdentity(ApplianceIdentity applianceIdentity);
}

