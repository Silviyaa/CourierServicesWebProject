package com.example.orders.City;

import com.example.orders.Office.Office;

import java.util.LinkedList;
import java.util.List;

public interface CityService {
    City FindCity (String CityCode);
    LinkedList<City> GetAllCities();
    City RegisterCity(City city);
    void RemoveCity(City city);
    List<Office> getAllOffices(City city);
    City saveCity(City city);
    City findCityById(Integer id);
}
