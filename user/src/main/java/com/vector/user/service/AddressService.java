package com.vector.user.service;

import com.vector.user.dto.AddressRequest;
import com.vector.user.dto.AddressResponse;

import java.util.List;
import java.util.UUID;

public interface AddressService {

    AddressResponse addAddress(UUID userId, AddressRequest request);

    List<AddressResponse> getUserAddresses(UUID userId);

    AddressResponse setDefaultAddress(UUID userId, UUID addressId);

    void deleteAddress(UUID userId, UUID addressId);
}