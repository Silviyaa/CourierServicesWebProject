package com.example.orders;

import com.example.orders.City.City;
import com.example.orders.City.CityRepository;
import com.example.orders.Office.Office;
import com.example.orders.Office.OfficeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback
public class CityRepositoryTest {
    @Autowired
    CityRepository cityRepository;

    @Autowired
    OfficeRepository officeRepository;

    @Test
    public void AddCity(){
        City city = new City("Varna","9000");
        var savedCity = cityRepository.save(city);
        Assertions.assertThat(savedCity).isNotNull();
    }
    @Test
    public void LookForCityByCode(){
        City city = new City("Plovdiv","8000");
        cityRepository.save(city);
        var savedCity = cityRepository.findCityByCityCode("8000");
        Assertions.assertThat(savedCity.getCityCode()).isEqualTo("8000");
    }

}
