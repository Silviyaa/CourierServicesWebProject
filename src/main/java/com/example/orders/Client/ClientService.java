package com.example.orders.Client;

import com.example.orders.Order.Order;

import java.util.List;
import java.util.Set;

public interface ClientService {
    public void RegisterClient(Client client);
    public boolean IsClientRegistered(String phoneNumber, String email);
    public Client SearchForClient(String info_user, String password) throws Exception;
    public Client CheckIfReceiverExists(String phoneNumber, String firstName,String lastName);
    public Client GetClientById(int id);
    public Set<Order> GetAllOrdersFromClient(int id);
}
