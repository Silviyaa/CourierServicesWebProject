package com.example.orders.Order;

import com.example.orders.Client.Client;
import com.example.orders.Courier.Courier;
import com.example.orders.Office.Office;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Order(){

    }
    public Order(Client sender, Courier courier, Office office, Client receiver) {
        this.sender = sender;
        this.courier = courier;
        this.office = office;
        this.dispatch = Date.valueOf(LocalDate.now());
        this.delivery = null;
        this.status = "In process";
        this.receiver = receiver;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer Id){
        this.id = Id;
    }

    @ManyToOne
    private Client sender;

    @ManyToOne
    private Courier courier;

    @Column(name = "dispatch")
    private java.sql.Date dispatch;

    @Column(name = "delivery",nullable = true)
    private java.sql.Date delivery;

    @Column(name = "status",nullable = false)
    private String status;

    @Column(name = "number")
    private String number;

    @ManyToOne
    private Office office;

    @ManyToOne
    private Client receiver;

    public Client getSender() {
        return sender;
    }

    public void setSender(Client sender) {
        this.sender = sender;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public Date getDispatch() {
        return dispatch;
    }

    public void setDispatch(Date dispatch) {
        this.dispatch = dispatch;
    }

    public Date getDelivery() {
        return delivery;
    }

    public void setDelivery(Date delivery) {
        this.delivery = delivery;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Client getReceiver() {
        return receiver;
    }

    public void setReceiver(Client receiver) {
        this.receiver = receiver;
    }

    public String getNumber(){
        return this.number;
    }
    public void setNumber(){
        this.number = this.id+sender.getFirstName().charAt(0)+sender.getLastName().charAt(0)+receiver.getLastName().charAt(0)+receiver.getLastName().charAt(0)+this.office.getCity().getCityCode();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus() {
        this.status = "Completed";
        this.delivery = (Date) Calendar.getInstance().getTime();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", sender=" + sender +
                ", courier=" + courier +
                ", dispatch=" + dispatch +
                ", delivery=" + delivery +
                ", office=" + office +
                ", receiver=" + receiver +
                '}';
    }
}
