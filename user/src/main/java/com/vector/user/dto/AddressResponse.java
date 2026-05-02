package com.vector.user.dto;

import java.util.UUID;

public class AddressResponse {

    private UUID id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String pincode;
    private String phone;
    private Boolean isDefault;

    public AddressResponse(UUID id, String name, String street, String city,
                           String state, String pincode, String phone, Boolean isDefault) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.phone = phone;
        this.isDefault = isDefault;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getPincode() { return pincode; }
    public String getPhone() { return phone; }
    public Boolean getIsDefault() { return isDefault; }
}
