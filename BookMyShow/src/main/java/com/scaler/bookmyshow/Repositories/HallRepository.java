package com.scaler.bookmyshow.Repositories;

import com.scaler.bookmyshow.Models.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {

}
