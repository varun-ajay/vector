package com.vector.user.repository;

import com.vector.user.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {

    // Get all addresses of a user
    List<Address> findByUserId(UUID userId);

    // Get default address of a user
    Optional<Address> findByUserIdAndIsDefaultTrue(UUID userId);

    // Find specific address by id + user (security check)
    Optional<Address> findByIdAndUserId(UUID id, UUID userId);

    // Delete address by id + user (safe delete)
    void deleteByIdAndUserId(UUID id, UUID userId);

    // Get all default addresses (rare use, but useful)
    List<Address> findByIsDefaultTrue();
}
