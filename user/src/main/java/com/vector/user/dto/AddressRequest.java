package com.vector.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class AddressRequest {

    private String name;

    @NotBlank
    private String street;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotBlank
    @Pattern(regexp = "\\d{6}", message = "Pincode must be 6 digits")
    private String pincode;

    @NotBlank
    @Size(min = 10, max = 15)
    private String phone;

    private Boolean isDefault = false;

    public String getName() { return name; }
    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getPincode() { return pincode; }
    public String getPhone() { return phone; }
    public Boolean getIsDefault() { return isDefault; }
}
