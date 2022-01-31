package com.example.orders.Courier;

import com.example.orders.Order.Order;
import javassist.util.proxy.ProxyFactory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

@Entity
@Table(name = "couriers")
public class Courier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(unique = true,name = "phoneNumber")
    private String phoneNumber;

    @Column(unique = true,name = "loginDetails")
    private String loginDetails;

    @OneToMany(mappedBy = "courier",cascade = CascadeType.ALL)
    private Set<Order> orders ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLoginDetails() {
        return loginDetails;
    }

    public void setLoginDetails(String loginDetails) {
        this.loginDetails = loginDetails;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public Courier(){
            orders = new HashSet<>();
    }
    public Courier(String firstName, String lastName, String phoneNumber, String loginDetails) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.loginDetails = loginDetails;
        this.orders = new HashSet<>();
    }
    public void AddOrderToList(Order order){
        orders.add(order);
        order.setCourier(this);
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
