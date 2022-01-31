package com.example.orders.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,Integer> {
    @Query("select c from Client c where c.phoneNumber = ?1")
    Client findClientByPhoneNumber(String phoneNumber);

    @Query("select c from Client c where c.firstName like %?1% and c.lastName like %?2%")
    Client findClientByFirstNameContainingAndLastNameContaining(String firstName, String lastName);

    @Query("select c from Client c where c.phoneNumber = ?1 and c.email = ?2")
    Client findClientByPhoneNumberAndEmail(String phoneNumber, String email);

    @Query("select c from Client c where c.phoneNumber = ?1 or c.email = ?1")
    Client findClientByPhoneNumberOrEmail(String info_user);

    @Query("select c from Client c where c.phoneNumber = ?1 and c.firstName = ?2 and c.lastName = ?3")
    Client findClientByPhoneNumberAndFirstNameAndLastName(String phoneNumber, String firstName, String lastName);



}
