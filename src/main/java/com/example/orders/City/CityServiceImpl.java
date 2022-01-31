package com.example.orders.City;

import com.example.orders.Office.Office;
import com.example.orders.Office.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService{

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private OfficeRepository officeRepository;

    @Override
    public City FindCity(String CityCode) {
        City city = cityRepository.findCityByCityCode(CityCode);
        return city;
    }

    @Override
    public LinkedList<City> GetAllCities() {
        LinkedList<City>cities= new LinkedList<>();
         cityRepository.findAll().forEach(city -> cities.add(city));
         return cities;
    }

    @Override
    public City RegisterCity(City city) {
        City cityNew = cityRepository.save(city);
        return cityNew;
    }

    @Override
    public void RemoveCity(City city) {
        cityRepository.delete(city);
    }

    @Override
    public List<Office> getAllOffices(City city) {
        return null;
    }


    @Override
    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City findCityById(Integer id) {
        if(cityRepository.existsById(id)){
            return cityRepository.findById(id).get();
        }else{
            return null;
        }
    }
}
