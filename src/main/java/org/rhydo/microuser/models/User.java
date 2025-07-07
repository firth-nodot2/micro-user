package org.rhydo.microuser.models;

import lombok.Data;
import org.rhydo.microuser.enums.UserRole;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "user_doc")
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;

    @Indexed(unique = true)
    private String email;

    private String phone;
    private UserRole role = UserRole.CUSTOMER;
    private Address address;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
