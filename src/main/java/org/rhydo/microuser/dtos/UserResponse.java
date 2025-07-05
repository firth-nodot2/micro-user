package org.rhydo.microuser.dtos;

import lombok.Data;
import org.rhydo.microuser.enums.UserRole;

@Data
public class UserResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private UserRole role;
    private AddressDTO address;
}
