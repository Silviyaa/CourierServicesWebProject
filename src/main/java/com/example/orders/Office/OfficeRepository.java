package com.example.orders.Office;

import com.example.orders.City.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OfficeRepository extends CrudRepository<Office,Integer> {

}
