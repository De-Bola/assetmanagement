package com.knit.assetmanagement.vendor.controller;

import com.knit.assetmanagement.vendor.Exceptions.VendorAlreadyExistException;
import com.knit.assetmanagement.vendor.Exceptions.VendorNoFoundException;
import com.knit.assetmanagement.vendor.model.Vendor;
import com.knit.assetmanagement.vendor.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:8080"})
public class VendorController {
    @Autowired
    private VendorService vendorService;

    public VendorController (VendorService service) {
        this.vendorService = service;
    }

    //@PostMapping(value = "/api/add-vendor", headers = {"accept", "*/*"})
    @PostMapping(value = "/api/add-vendor")
    @ResponseStatus(HttpStatus.CREATED)
    public Vendor addVendor(@RequestBody Vendor vendor) throws Exception, VendorAlreadyExistException {
        return vendorService.addVendor(vendor);
    }

    @GetMapping(value = "/api/get-vendor-by-name/{name}")
    public ResponseEntity<?> getEmployeeByName(@PathVariable String name) throws Throwable{
        try{
            return ResponseEntity.ok(vendorService.getVendorByName(name));
        }
        catch (VendorNoFoundException vnfe){
            vnfe.getMessage();
        }
        catch (Exception e){
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
