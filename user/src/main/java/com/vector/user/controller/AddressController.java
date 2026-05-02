package com.vector.user.controller;

import com.vector.user.dto.AddressRequest;
import com.vector.user.dto.AddressResponse;
import com.vector.user.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<AddressResponse> addAddress(@Valid @RequestBody AddressRequest request) {
        AddressResponse response = addressService.addAddress(request.getUserId(), request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<AddressResponse>> getUserAddresses(@PathVariable UUID userId) {
        return ResponseEntity.ok(addressService.getUserAddresses(userId));
    }

    @PutMapping("/{userId}/default/{addressId}")
    public ResponseEntity<AddressResponse> setDefault(@PathVariable UUID userId,
                                                       @PathVariable UUID addressId) {
        return ResponseEntity.ok(addressService.setDefaultAddress(userId, addressId));
    }

    @DeleteMapping("/{userId}/{addressId}")
    public ResponseEntity<Void> deleteAddress(@PathVariable UUID userId,
                                               @PathVariable UUID addressId) {
        addressService.deleteAddress(userId, addressId);
        return ResponseEntity.noContent().build();
    }
}
