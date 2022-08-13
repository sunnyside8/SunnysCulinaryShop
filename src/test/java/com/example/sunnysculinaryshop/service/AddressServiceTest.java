package com.example.sunnysculinaryshop.service;

import com.example.sunnysculinaryshop.model.entity.Address;
import com.example.sunnysculinaryshop.repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AddressServiceTest {
    Address address;

    @Mock
    AddressRepository addressRepository;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    AddressService addressService;

    @BeforeEach
    void setMockOutput() {
        address = new Address();
    }


    @Test
    void getAddressStringByUserId() {
        when(addressRepository.getByUser_Id(1L)).thenReturn(address);

        Address addressStringByUserId = addressService.getAddressStringByUserId(1L);

        assertEquals(addressStringByUserId, address);
    }
}