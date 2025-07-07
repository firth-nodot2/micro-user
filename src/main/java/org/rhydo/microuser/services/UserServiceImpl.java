package org.rhydo.microuser.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.rhydo.microuser.dtos.UserRequest;
import org.rhydo.microuser.dtos.UserResponse;
import org.rhydo.microuser.exceptions.ResourceNotFoundException;
import org.rhydo.microuser.models.Address;
import org.rhydo.microuser.models.User;
import org.rhydo.microuser.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<UserResponse> fetchAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserResponse.class))
                .toList();
    }

    @Override
    public void addUser(UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        userRepository.save(user);
    }

    @Override
    public UserResponse fetchUser(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public UserResponse updateUser(String id, UserRequest updateduserRequest) {
        User updateduser = modelMapper.map(updateduserRequest, User.class);

        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setFirstName(updateduser.getFirstName());
                    existingUser.setLastName(updateduser.getLastName());
                    existingUser.setEmail(updateduser.getEmail());
                    existingUser.setPhone(updateduser.getPhone());

                    if (updateduserRequest.getAddress() != null) {
                        Address existingAddress = existingUser.getAddress();

                        if (existingAddress == null) {
                            existingAddress = new Address();
                            existingUser.setAddress(existingAddress);
                        }

                        existingAddress.setStreet(updateduserRequest.getAddress().getStreet());
                        existingAddress.setCity(updateduserRequest.getAddress().getCity());
                        existingAddress.setState(updateduserRequest.getAddress().getState());
                        existingAddress.setCountry(updateduserRequest.getAddress().getCountry());
                        existingAddress.setZipcode(updateduserRequest.getAddress().getZipcode());
                    }

                    User user = userRepository.save(existingUser);
                    return modelMapper.map(user, UserResponse.class);
                }).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }
}
