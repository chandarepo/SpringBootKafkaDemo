package com.example.demo.controllor;


import com.example.demo.bean.*;
import com.example.demo.service.ApplianceService;
import com.example.demo.util.Constants;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appliance-demo")
public class ApplianceControllor {

    private final Logger log =
            LoggerFactory.getLogger(ApplianceControllor.class);

    @Autowired
    ApplianceService applianceService;

    @ApiOperation(value = "Get all appliance ", response = List.class)
    @CrossOrigin(origins = Constants.FrontEnd_URL)
    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Appliance>> getAll() {
        try {
            List<Appliance> applianceList = applianceService.getAllAppliances();
            return new ResponseEntity<>(applianceList, HttpStatus.OK);
        }catch (Exception ex){
            log.error(ex.getMessage());
        }
        return new ResponseEntity<>( HttpStatus.EXPECTATION_FAILED);
    }

    @ApiOperation(value = "Create appliance ", response = Appliance.class)
    @CrossOrigin(origins = Constants.FrontEnd_URL)
    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Appliance> createAppliance(@RequestBody Appliance appliance) {
        try {
            Appliance  appl = applianceService.createAppliance(appliance);
            return new ResponseEntity<>(appl, HttpStatus.CREATED);
        }catch (Exception ex){
            log.error(ex.getMessage());
        }
        return new ResponseEntity<>( HttpStatus.EXPECTATION_FAILED);
    }

    @ApiOperation(value = "update appliance ", response = Appliance.class)
    @CrossOrigin(origins = Constants.FrontEnd_URL)
    @PostMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Appliance> updateAppliance(@RequestBody Appliance appliance) {
        try {
            Appliance  appl = applianceService.updateAppliance(appliance);
            return new ResponseEntity<>(appl, HttpStatus.OK);
        }catch (Exception ex){
            log.error(ex.getMessage());
        }
        return new ResponseEntity<>( HttpStatus.EXPECTATION_FAILED);
    }

    @ApiOperation(value = "Delete appliance ", response = Appliance.class)
    @CrossOrigin(origins = Constants.FrontEnd_URL)
    @DeleteMapping(path = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<HttpStatus> deleteAppliance(@RequestBody Appliance appliance) {
        try {
            applianceService.deleteAppliance(appliance);
            return new ResponseEntity<>( HttpStatus.ACCEPTED);
        }catch (Exception ex){
            log.error(ex.getMessage());
        }
        return new ResponseEntity<>( HttpStatus.EXPECTATION_FAILED);
    }

    @ApiOperation(value = "Get appliance by Brand Name like", response = Appliance.class)
    @CrossOrigin(origins = Constants.FrontEnd_URL)
    @GetMapping(path = "/search/brand/{brandNameLike}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Appliance>> getApplianceByBrand(@PathVariable String brandNameLike) {

        if(!brandNameLike.matches("[A-Za-z0-9]+$") )
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);

        try {
            List<Appliance> applianceList =
                    applianceService.getAllAppliancesByBrand("%"+brandNameLike+"%");
            return new ResponseEntity<>(applianceList, HttpStatus.OK);
        }catch (Exception ex){
            log.error(ex.getMessage());
        }
        return new ResponseEntity<>( HttpStatus.EXPECTATION_FAILED);
    }

    @ApiOperation(value = "Get appliance by Status Name like", response = Appliance.class)
    @CrossOrigin(origins = Constants.FrontEnd_URL)
    @GetMapping(path = "/search/status/{statusNameLike}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Appliance>> getApplianceByStatus(@PathVariable ApplicanceStatus statusNameLike) {

        if(!statusNameLike.toString().matches("[A-Z]+$") )
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);

        try {
            List<Appliance> applianceList =
                    applianceService.getAllAppliancesByStatus(statusNameLike);
            return new ResponseEntity<>(applianceList, HttpStatus.OK);
        }catch (Exception ex){
            log.error(ex.getMessage());
        }
        return new ResponseEntity<>( HttpStatus.EXPECTATION_FAILED);
    }

    @ApiOperation(value = "Get appliance by SrNum like ", response = Appliance.class)
    @CrossOrigin(origins = Constants.FrontEnd_URL)
    @GetMapping(path = "/search/srNum/{srNumLike}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Appliance>> getAllApplianceBySrNum(@PathVariable String srNumLike) {

        if(!srNumLike.matches("[A-Za-z0-9]+$") )
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);

        try {
            List<Appliance> applianceList =
                    applianceService.getAllAppliancesBySerialNumber("%"+srNumLike+"%");
            return new ResponseEntity<>(applianceList, HttpStatus.OK);
        }catch (Exception ex){
            log.error(ex.getMessage());
        }
        return new ResponseEntity<>( HttpStatus.EXPECTATION_FAILED);
    }
}
