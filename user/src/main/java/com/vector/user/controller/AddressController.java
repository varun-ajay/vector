package com.vector.user.controller;

import com.vector.user.dto.AddressRequest;
import com.vector.user.dto.AddressResponse;
import com.vector.user.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
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
        String userId = (String) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        AddressResponse response = addressService.addAddress(UUID.fromString(userId), request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<AddressResponse>> getUserAddresses() {
        String userId = (String) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return ResponseEntity.ok(addressService.getUserAddresses(UUID.fromString(userId)));
    }

    @PutMapping("/default/{addressId}")
    public ResponseEntity<AddressResponse> setDefault(@PathVariable UUID addressId) {
        String userId = (String) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return ResponseEntity.ok(addressService.setDefaultAddress(UUID.fromString(userId), addressId));
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<Void> deleteAddress(@PathVariable UUID addressId) {
        String userId = (String) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        addressService.deleteAddress(UUID.fromString(userId), addressId);
        return ResponseEntity.noContent().build();
    }
}
