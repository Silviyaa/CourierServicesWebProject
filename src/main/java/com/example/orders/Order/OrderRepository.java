package com.example.orders.Order;

import com.example.orders.Client.Client;
import com.example.orders.Courier.Courier;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order,Integer> {
    @Query("select o from Order o where o.sender = ?1")
    Collection<Order> findAllBySender(Client sender);
    @Query("select o from Order o where o.courier = ?1")
    Collection<Order> findAllByCourier(Courier courier);

    @Query("select (count(o) > 0) from Order o where o.number = ?1")
    boolean existsByNumber(String number);
    @Query("select o from Order o where o.number = ?1")
    Order getByNumber(String number);
}
