package org.rhydo.microuser.repositories;

import org.rhydo.microuser.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
