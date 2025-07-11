package org.rhydo.microuser.services;

import org.rhydo.microuser.dtos.UserRequest;
import org.rhydo.microuser.dtos.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> fetchAllUsers();

    void addUser(UserRequest userRequest);

    UserResponse fetchUser(String id);

    UserResponse updateUser(String id, UserRequest updateduser);
}
