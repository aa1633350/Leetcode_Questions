package com.example.demo.MachineCodingPractice.BikeRentalWayfair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RentalShop {

    List<Product> inventory;
    List<Product> rentedProducts;
    List<Customer> customers;
    Map<String, List<Product>> customerRentals;

    RentalShop() {
        this.inventory = new ArrayList<>();
        this.rentedProducts = new ArrayList<>();
        this.customers = new ArrayList<>();
        customerRentals = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.add(product);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    public void removeDamagedProduct(String productId) {
        inventory.removeIf(product -> product.getId().equals(productId));
    }

    public void recordRentedProduct(String productId, String customerId) {
        Customer customer = customers.stream().filter(cust -> cust.getId().equals(customerId)).findFirst().orElse(null);

        for(Product product : inventory) {
            if(product.getId().equals(productId) && !product.isRented()) {
                if(customer != null) {
                    product.setRented(true);
                    removeDamagedProduct(productId);
                    customerRentals.computeIfAbsent(customer.getName(), k-> new ArrayList<>()).add(product);
                    break;
                } else {
                    System.out.println("Throw Invalid customer id exception");
                }

            }
        }
    }


}
