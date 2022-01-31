package com.example.orders.City;

import com.example.orders.Office.Office;


import javax.persistence.*;

import java.util.*;


@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String cityName;

    @Column(unique = true)
    private String cityCode;

    @OneToMany(targetEntity = Office.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id",referencedColumnName = "id")
    private Set<Office> officeList ;
    public City() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public Set<Office> getOfficeList() {
        return officeList;
    }

    public City(String cityName, String cityCode) {
        this.cityName = cityName;
        this.cityCode = cityCode;
        this.officeList = new HashSet<>();
    }
    public void AddOffice(Office office){
        this.officeList.add(office);
        office.setCity(this);
    }

    public void RemoveOffice(String address){
      officeList.removeIf(office -> office.getAddress()==address);
    }
}
