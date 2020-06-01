package com.example.demo.service;


import com.example.demo.bean.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *  Searchable list of all recorded appliances
 * Can be filtered using the provided search filters
 *  Serial Number
 *  Brand
 *  Model
 *  Status
 *  Date Bought
 *  Create a new record of my appliance not found in the list
 * System will show an error message if the same appliance is already found by identifying:
 *  Serial Number
 *  Brand
 *  Model
 *  Update the details of an appliance
 * Serial Number Brand
 * Model
 * Date Bought Status
 *  Remove old/unused/sold appliance from the list
 */
@Service
public interface ApplianceService {
    public void deleteAppliance(Appliance appliance);
    public Appliance updateAppliance(Appliance appliance);
    public Appliance createAppliance(Appliance appliance);
    public List<Appliance> getAllAppliances();
    public List<Appliance> getAllAppliancesBySerialNumber(String srNum);
    public List<Appliance> getAllAppliancesByBrand(String brand);
    public List<Appliance> getAllAppliancesByStatus(ApplicanceStatus status);
    public List<Appliance> getAllAppliancesByPurchaseDate(Date date);
    public List<Appliance> getAllAppliancesByModel(String model);
}
