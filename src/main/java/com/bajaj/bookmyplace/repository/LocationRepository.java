package com.bajaj.bookmyplace.repository;

import com.bajaj.bookmyplace.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
