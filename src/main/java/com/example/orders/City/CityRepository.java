package com.example.orders.City;

import com.example.orders.Office.Office;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public interface CityRepository extends CrudRepository<City,Integer> {
    @Query("select c from City c where c.cityName= ?1")
    City findCityByCityCode(String CityCode);
    @Query("select c from City c where c.cityCode = ?1 and c.cityName = ?2")
    City findByCityCodeAndCityName(String cityCode, String cityName);

}
