package com.knit.assetmanagement.vendor.service;

import com.knit.assetmanagement.vendor.Exceptions.VendorAlreadyExistException;
import com.knit.assetmanagement.vendor.Exceptions.VendorNoFoundException;
import com.knit.assetmanagement.vendor.model.Vendor;
import com.knit.assetmanagement.vendor.repo.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorService {
    @Autowired
    private VendorRepository vendorRepository;

    public VendorService(VendorRepository repository){
        this.vendorRepository = repository;
    }

    public Vendor addVendor(Vendor vendor) throws VendorAlreadyExistException{
        if(vendorRepository.findByName(vendor.getName()) != null) throw new VendorAlreadyExistException("Duplicates are not allowed");
        return vendorRepository.save(vendor);
    }

    public Vendor getVendorByName(String name) throws VendorNoFoundException {
        Vendor vendor = vendorRepository.findByName(name);
        if(vendor == null) throw new VendorNoFoundException("This vendor is not found");
        return vendor;
    }
}
