package com.njoyfashion.converter;

import com.njoyfashion.dto.SupplierDto;
import com.njoyfashion.entity.Supplier;
import org.springframework.stereotype.Component;

@Component
public class SupplierConverter {

    public SupplierDto convert(Supplier supplier){
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setId(supplier.getId());
        supplierDto.setName(supplier.getName());
        supplierDto.setContactNumber(supplier.getContactNumber());
        return supplierDto;
    }

    public Supplier convert(SupplierDto supplierDto){
        Supplier supplier = new Supplier();
        supplier.setId(supplierDto.getId());
        supplier.setName(supplierDto.getName());
        supplier.setContactNumber(supplierDto.getContactNumber());
        return supplier;
    }

}
