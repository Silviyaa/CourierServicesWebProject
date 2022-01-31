package com.example.orders;

import com.example.orders.City.City;
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

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback
public class ClientRepositoryTest {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CourierRepository courierRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    OfficeRepository officeRepository;

    @Test
    public void AddClient(){
        var client = new Client("Ivelin","Nikolov","inikolov@gmail.com","0882737002","23932");
        clientRepository.save(client);
        var clientByPhone = clientRepository.findClientByPhoneNumber("0882737002");
        Assertions.assertThat(clientByPhone.getFirstName()).isEqualTo("Ivelin");
        var client1 = new Client("Nayden","Alexiev","n882318@hotmail.com","089355446","23132");
        clientRepository.save(client1);
        var clientByFirstNameAndLastName = clientRepository.findClientByFirstNameContainingAndLastNameContaining("Nayden","Alexiev");
        Assertions.assertThat(clientByFirstNameAndLastName.getFirstName()).isEqualTo("Nayden");
        Assertions.assertThat(clientByFirstNameAndLastName.getLastName()).isEqualTo("Alexiev");
    }
    @Test
    public void AddOfficesToCity(){

       var city = cityRepository.save(new City("Karlovo","0335"));
       city.AddOffice(officeRepository.save(new Office("ul.Mladejka 5")));
       city.AddOffice(officeRepository.save(new Office("ul.Chervena Yabylka")));
       cityRepository.save(city);
       city.getOfficeList().forEach(office -> System.out.println(office.getCity().getId()+" "+office.getAddress()));
    }
    @Test
    public void FindOutIfClientExistsByPhoneNumberAndEmailAddress(){
       clientRepository.save(new Client("Daniel","Dimitrov","088993646","d_dimitrov@gmail.com","1231"));
       Client client = clientRepository.findClientByPhoneNumberAndEmail("088993646","d_dimitrov@gmail.com");
       Assertions.assertThat(client).isNotNull();
       Assertions.assertThat(client.getFirstName()).isEqualTo("Daniel");
       Assertions.assertThat(client.getLastName()).isEqualTo("Dimitrov");
       Client wrongClient = clientRepository.findClientByPhoneNumberAndEmail("088577889","marina1009@hotmail.com");
       Assertions.assertThat(wrongClient).isNull();
       System.out.println(client.getFirstName()+"\n"+client.getLastName()+"\n"+client.getPhoneNumber()+"\n"+client.getEmail());
     }
     @Test
    public void TestFindingClientByPhoneNumberOrEmail(){
        clientRepository.save(new Client("Doncho","Nikolov","089778990","d_cornflower29_92@yahoo.com","did888892"));
        Client isFound = clientRepository.findClientByPhoneNumberOrEmail("d_cornflower29_92@yahoo.com");
        Assertions.assertThat(isFound.getPassword()).isEqualTo("did888892");
        isFound = clientRepository.findClientByPhoneNumberOrEmail("0884730788");
        Assertions.assertThat(isFound).isNull();
     }
     @Test
    public void TestWhetherAClientCanBeFoundByPhoneNumberFirstNameAndLastName(){
         clientRepository.save(new Client("Doncho","Nikolov","089778990","d_cornflower29_92@yahoo.com","did888892"));
         clientRepository.save(new Client("Miroslav","Denkov","08845456787","mirko@yahoo.com","238382"));

         var clientCheck = clientRepository.findClientByPhoneNumberAndFirstNameAndLastName("089778990","Doncho","Nikolov");
         Assertions.assertThat(clientCheck.getLastName()).isEqualTo("Nikolov");
         clientCheck   = clientRepository.findClientByPhoneNumberAndFirstNameAndLastName("29319232","2391","23");
         Assertions.assertThat(clientCheck).isNull();

     }

}
