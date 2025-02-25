package com.lab._4.repository;

import com.lab._4.model.Customer;
import com.lab._4.model.CustomerStatus;
import com.lab._4.model.Flight;
import com.lab._4.model.FlightBooking;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class AllRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    FlightBookingRepository flightBookingRepository;

    @Autowired
    FlightRepository flightRepository;

    @BeforeEach
    public void setUp(){
        Customer c1 = new Customer("Agustine Riviera", CustomerStatus.SILVER,115235);
        Customer c2 = new Customer("Alaina Sepluvida",CustomerStatus.NONE, 6008);
        Customer c3 = new Customer("Tom Jones",CustomerStatus.GOLD, 205767);
        Customer c4 = new Customer("Sam Rio",CustomerStatus.NONE, 2653);
        Customer c5 = new Customer("Jessica James",CustomerStatus.SILVER, 136773);
        Customer c6 = new Customer("Ana Janco",CustomerStatus.SILVER, 136773);
        Customer c7 = new Customer("Jennifer Cortez",CustomerStatus.GOLD, 300582);
        Customer c8 = new Customer("Christian Janco",CustomerStatus.SILVER,14642);
        customerRepository.save(c1);
        customerRepository.save(c2);
        customerRepository.save(c3);
        customerRepository.save(c4);
        customerRepository.save(c5);
        customerRepository.save(c6);
        customerRepository.save(c7);
        customerRepository.save(c8);
        Flight f1 = new Flight("DL143","Boeing 747",400,135);
        Flight f2 = new Flight("DL122","Airbus A330",236,4370);
        Flight f3 = new Flight("DL53","Boeing 777",264,2078);
        Flight f4 = new Flight("DL222","Boeing 777",264,1765);
        Flight f5 = new Flight("DL37","Boeing 747",400,531);
        flightRepository.save(f1);
        flightRepository.save(f2);
        flightRepository.save(f3);
        flightRepository.save(f4);
        flightRepository.save(f5);
        FlightBooking fb1 = new FlightBooking(1,1);
        FlightBooking fb2 = new FlightBooking(1,2);
        FlightBooking fb3 = new FlightBooking(2,2);
        FlightBooking fb4 = new FlightBooking(3,2);
        FlightBooking fb5 = new FlightBooking(3,3);
        FlightBooking fb6 = new FlightBooking(4,1);
        FlightBooking fb7 = new FlightBooking(3,4);
        FlightBooking fb8 = new FlightBooking(5,1);
        FlightBooking fb9 = new FlightBooking(6,4);
        FlightBooking fb10 = new FlightBooking(7,4);
        FlightBooking fb11 = new FlightBooking(5,2);
        FlightBooking fb12 = new FlightBooking(4,5);
        FlightBooking fb13 = new FlightBooking(8,4);
        flightBookingRepository.save(fb1);
        flightBookingRepository.save(fb2);
        flightBookingRepository.save(fb3);
        flightBookingRepository.save(fb4);
        flightBookingRepository.save(fb5);
        flightBookingRepository.save(fb6);
        flightBookingRepository.save(fb7);
        flightBookingRepository.save(fb8);
        flightBookingRepository.save(fb9);
        flightBookingRepository.save(fb10);
        flightBookingRepository.save(fb11);
        flightBookingRepository.save(fb12);
        flightBookingRepository.save(fb13);
    }

    @AfterEach
    public void tearDown() {
        customerRepository.deleteAll();
        flightRepository.deleteAll();
        flightBookingRepository.deleteAll();
    }

    @Test
    public void createCustomer_validInput_customerList(){
        Customer newone = new Customer("John Doe",CustomerStatus.GOLD,45_600);
        customerRepository.save(newone);
        List<Customer> customerList = customerRepository.findAll();
        System.out.println(customerList);
        assertEquals(9,customerList.size());
    }

    @Test
    public void createFlight_validInput_flightList(){
        Flight newone = new Flight("AD233","Boeing 777",264,980);
        flightRepository.save(newone);
        List<Flight> flightList = flightRepository.findAll();
        System.out.println(flightList);
        assertEquals(6,flightList.size());
    }

    @Test
    public void findCustomersByName_validInput_customerList(){
        Optional<Customer> customerOptional = customerRepository.findByCustomerName("Tom Jones");
        assertTrue(customerOptional.isPresent());
        System.out.println(customerOptional.get());
        assertEquals(205767,customerOptional.get().getTotalCustomerMileage());
    }

    @Test
    public void findAllCustomersByStatus_validInput_customerList(){
        List<Customer> customerList = customerRepository.findAllByStatus(CustomerStatus.NONE);
        System.out.println(customerList);
        assertEquals(2, customerList.size());
    }

    @Test
    public void findFlightByNumber_validInput_correctFlight(){
        Optional<Flight> optionalFlight = flightRepository.findByFlightNumber("DL122");
        assertTrue(optionalFlight.isPresent());
        System.out.println(optionalFlight.get());
        assertEquals(4370,optionalFlight.get().getFlightMileage());
    }

    @Test
    public void findAllFlightsByAircraftContaining_validInput_flightList(){
        List<Flight> flightList = flightRepository.findAllByAircraftContaining("boeing");
        System.out.println(flightList);
        assertEquals(4,flightList.size());
    }

    @Test
    public void findAllFlightByMileageGreaterThan_validInput_flightList(){
        List<Flight> flightList = flightRepository.findAllByFlightMileageGreaterThan(500);
        System.out.println(flightList);
        assertEquals(4,flightList.size());
    }

}