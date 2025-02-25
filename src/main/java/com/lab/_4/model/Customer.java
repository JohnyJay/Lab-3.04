package com.lab._4.model;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String customerName;

    @Enumerated(EnumType.ORDINAL)
    private CustomerStatus status;

    private int totalCustomerMileage;

    public Customer() {
    }

    public Customer(String customerName, CustomerStatus status, int totalCustomerMileage) {
        this.customerName = customerName;
        this.status = status;
        this.totalCustomerMileage = totalCustomerMileage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerStatus status) {
        this.status = status;
    }

    public int getTotalCustomerMileage() {
        return totalCustomerMileage;
    }

    public void setTotalCustomerMileage(int totalCustomerMileage) {
        this.totalCustomerMileage = totalCustomerMileage;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", status=" + status +
                ", totalCustomerMileage=" + totalCustomerMileage +
                '}';
    }
}
