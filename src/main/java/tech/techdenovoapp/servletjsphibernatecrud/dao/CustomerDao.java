package tech.techdenovoapp.servletjsphibernatecrud.dao;

import tech.techdenovoapp.servletjsphibernatecrud.domain.Customer;

import java.sql.Connection;
import java.util.List;

public interface CustomerDao {
    Connection saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
   void deleteCustomer(Long id);
   Connection findCustomerById(Long id);
   List<Customer> findAllCustomers();
}
