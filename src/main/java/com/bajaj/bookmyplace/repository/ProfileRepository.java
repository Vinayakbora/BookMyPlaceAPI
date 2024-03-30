package com.bajaj.bookmyplace.repository;


import com.bajaj.bookmyplace.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String name);

}
