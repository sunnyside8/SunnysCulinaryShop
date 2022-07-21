package com.example.sunnysculinaryshop.service;

import com.example.sunnysculinaryshop.model.binding.AddressBindingModel;
import com.example.sunnysculinaryshop.model.entity.Address;
import com.example.sunnysculinaryshop.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    public AddressService(AddressRepository addressRepository, ModelMapper modelMapper) {
        this.addressRepository = addressRepository;
        this.modelMapper = modelMapper;
    }

    public Address addNewAddress(AddressBindingModel addressBindingModel) {
        Address address = modelMapper.map(addressBindingModel,Address.class);
        System.out.println();
        return addressRepository.save(address);
    }
}
