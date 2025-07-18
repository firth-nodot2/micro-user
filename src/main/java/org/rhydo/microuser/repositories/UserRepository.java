package org.rhydo.microuser.repositories;

import org.rhydo.microuser.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
