package com.example.orders.Client;

import com.example.orders.Order.Order;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "clients")
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(unique = true,name = "email")
    private String email;

    @Column(unique = true,name = "phoneNumber")
    private String phoneNumber;
    @Column(unique = true,name = "password")
    private String password;

    @OneToMany(mappedBy = "receiver")
    private Set<Order> assignedOrders;

    @OneToMany(mappedBy = "sender")
    private Set<Order> sentOrders;

    public Client() {
        assignedOrders = new HashSet<>();
        sentOrders  = new HashSet<>();
    }


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Order> getAssignedOrders() {
        return assignedOrders;
    }

    public void setAssignedOrders(Set<Order> assignedOrders) {
        this.assignedOrders = assignedOrders;
    }

    public Client(String firstName, String lastName,String phoneNumber, String email,String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.assignedOrders = new HashSet<>();
        this.sentOrders = new HashSet<>();
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public Set<Order> getSentOrders() {
        return sentOrders;
    }

    public void setSentOrders(Set<Order> sentOrders) {
        this.sentOrders = sentOrders;
    }
    public void AddOrder(Order order){
        this.sentOrders.add(order);
    }
    public void AssignOrder(Order order){
        this.assignedOrders.add(order);
    }
}
