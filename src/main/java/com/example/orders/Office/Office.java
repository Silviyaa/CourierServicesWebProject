package com.example.orders.Office;

import com.example.orders.City.City;
import com.example.orders.Order.Order;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "offices")
public class Office{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String address;

    @ManyToOne
    private City city;
    @OneToMany(mappedBy = "office")
    private Set<Order> orders;


    public Office(String address) {
        this.setAddress(address);
    }

    public Office() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
