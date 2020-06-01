package com.example.demo.service.imp;


import com.example.demo.bean.*;
import com.example.demo.repository.ApplianceRepository;
import com.example.demo.service.ApplianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApplianceServiceImpl implements ApplianceService {

    @Autowired
    ApplianceRepository applianceRepository;

    @Override
    public void deleteAppliance(Appliance appliance) {
        applianceRepository.delete(appliance);
    }

    @Override
    public Appliance updateAppliance(Appliance appliance) {
        return applianceRepository.saveAndFlush(appliance);
    }

    @Override
    public Appliance createAppliance(Appliance appliance) {
        return applianceRepository.save(appliance);
    }

    @Override
    public List<Appliance> getAllAppliances() {
        return applianceRepository.findAll();
    }

    @Override
    public List<Appliance> getAllAppliancesBySerialNumber(String srNum) {
        return applianceRepository.findByApplianceIdentitySerialNumberLike(srNum);
    }

    @Override
    public List<Appliance> getAllAppliancesByBrand(String brand) {
        return applianceRepository.findByApplianceIdentityBrandLike(brand);
    }
    @Override
    public List<Appliance> getAllAppliancesByModel(String model) {
        return applianceRepository.findByApplianceIdentityModelLike(model);
    }
    @Override
    public List<Appliance> getAllAppliancesByStatus(ApplicanceStatus status) {
        return applianceRepository.findByStatusLike(status);
    }

    @Override
    public List<Appliance> getAllAppliancesByPurchaseDate(Date date) {
        return applianceRepository.findByBoughtDate(date);
    }
}
