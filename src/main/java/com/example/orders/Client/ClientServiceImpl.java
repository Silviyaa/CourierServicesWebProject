package com.example.orders.Client;

import com.example.orders.Order.Order;
import com.example.orders.Order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public void RegisterClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public boolean IsClientRegistered(String phoneNumber, String email) {
        var client = clientRepository.findClientByPhoneNumberAndEmail(phoneNumber,email);
        if(client==null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Client SearchForClient(String info_user, String password) throws Exception {
        var client = clientRepository.findClientByPhoneNumberOrEmail(info_user);
        if(client==null){
           throw new Exception("Client with such personal information doesn't exist on our system!");
        }
        if(!client.getPassword().equals(password)){
           throw new Exception("Incorrect personal information!");
        }
        return client;
    }

    @Override
    public Client CheckIfReceiverExists(String phoneNumber, String firstName, String lastName) {
        return clientRepository.findClientByPhoneNumberAndFirstNameAndLastName(phoneNumber,firstName,lastName);
    }

    @Override
    public Client GetClientById(int id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public Set<Order> GetAllOrdersFromClient(int id) {
        var client = clientRepository.findById(id).get();
        return client.getSentOrders();
    }

}
