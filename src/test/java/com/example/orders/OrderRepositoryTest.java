package com.example.orders;


import com.example.orders.City.CityRepository;
import com.example.orders.Client.Client;
import com.example.orders.Client.ClientRepository;
import com.example.orders.Courier.Courier;
import com.example.orders.Courier.CourierRepository;
import com.example.orders.Office.Office;
import com.example.orders.Office.OfficeRepository;
import com.example.orders.Order.Order;
import com.example.orders.Order.OrderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback
public class OrderRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private OfficeRepository officeRepository;
    @Autowired
    private CourierRepository courierRepository;


    @Test
    public void RegisterOrder(){
        var sender = clientRepository.save(new Client("Iren","Borislavova","0894456767","ireniren_cocoa@gmail.com","23838"));
        var receiver = clientRepository.save(new Client("Andrey","Miroslavov","0887343560","paprika_cinnamon_bun@hotmail.com","238328123"));
        var city  = cityRepository.findCityByCityCode("9000");
        var officeOrder = officeRepository.findById(236).get();
        var courier = courierRepository.save(new Courier("Venelin","Gabrielov","0883840974","vg974"));
        Assertions.assertThat(courier.getId()).isGreaterThan(0);
        Assertions.assertThat(city).isNotNull();
        System.out.println(city.getCityCode()+" is the name of the city with city code [9000]");
        List<Office> officeList = new LinkedList<>();
        officeRepository.findAll().forEach(office -> officeList.add(office));
        //officeList.forEach(office -> System.out.println(office.getId()+" "+office.getCity().getCityCode()+" "+office.getAddress()));

        orderRepository.save(new Order(sender, courier,officeOrder,receiver)).setNumber();
        orderRepository.save(new Order(sender, courier,officeOrder,receiver)).setNumber();
        orderRepository.save(new Order(sender, courier,officeOrder,receiver)).setNumber();
        orderRepository.save(new Order(sender, courier,officeOrder,receiver)).setNumber();
        orderRepository.save(new Order(sender, courier,officeOrder,receiver)).setNumber();
        orderRepository.save(new Order(sender, courier,officeOrder,receiver)).setNumber();
        orderRepository.save(new Order(sender, courier,officeOrder,receiver)).setNumber();
        var allOrders = orderRepository.findAll();
        var iterator = allOrders.iterator();
        System.out.println("\n\n\nOrders: ");
        while(iterator.hasNext()){
            System.out.println(iterator.next().getId());
        }
        iterator = allOrders.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getNumber());
        }
        var order = orderRepository.existsByNumber("663Varna");
        //Assertions.assertThat(order).isTrue();
    }
    @Test
    public void TestCourierOrderAssignmentList(){
        var sender = clientRepository.save(new Client("Iren","Borislavova","0894456767","ireniren_cocoa@gmail.com","23838"));
        var receiver = clientRepository.save(new Client("Andrey","Miroslavov","0887343560","paprika_cinnamon_bun@hotmail.com","238328123"));
        var city  = cityRepository.findCityByCityCode("9000");
        var officeOrder = officeRepository.findById(236).get();
        var courier = courierRepository.save(new Courier("Venelin","Gabrielov","0883840974","vg974"));

        var o1 = orderRepository.save(new Order(sender, new Courier(),officeOrder,receiver));
        o1.setDispatch(new Date(122,1,10));
        var o2 = orderRepository.save(new Order(sender, new Courier(),officeOrder,receiver));
        o2.setDispatch(new Date(122,1,10));
        var o3 = orderRepository.save(new Order(sender, new Courier(),officeOrder,receiver));
        o3.setDispatch(new Date(122,1,10));
        var o4 = orderRepository.save(new Order(sender, new Courier(),officeOrder,receiver));
        o4.setDispatch(new Date(122,1,10));
        var o5 = orderRepository.save(new Order(sender, new Courier(),officeOrder,receiver));
        o5.setDispatch(new Date(122,1,10));
        var o6 = orderRepository.save(new Order(sender, new Courier(),officeOrder,receiver));
        o6.setDispatch(new Date(122,1,10));
        courier.AddOrderToList(o1);
        courier.AddOrderToList(o2);
        courier.AddOrderToList(o3);
        courier.AddOrderToList(o4);
        courier.AddOrderToList(o5);
        courier.AddOrderToList(o6);
        Assertions.assertThat(courier.getOrders().size()).isEqualTo(6);
        orderRepository.save(o1);
        orderRepository.save(o2);
        orderRepository.save(o3);
        orderRepository.save(o4);
        orderRepository.save(o5);
        orderRepository.save(o6);
        var newUpdatedListCourier = courierRepository.save(courier);
        var orders = newUpdatedListCourier.getOrders();
        Assertions.assertThat(orders.size()).isEqualTo(6);
        orders.forEach(order -> System.out.println(order.getId()+" "+order.getDispatch()+" "+order.getCourier().getFirstName()));


    }
    @Test
    public void TestOrder(){
        var order = orderRepository.save(new Order());
        Assertions.assertThat(order.getId()).isGreaterThan(0);
        System.out.println(order.getId());
    }
}
