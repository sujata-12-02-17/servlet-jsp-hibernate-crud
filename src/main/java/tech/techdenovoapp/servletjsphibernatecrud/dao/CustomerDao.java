package tech.techdenovoapp.servletjsphibernatecrud.dao;

import tech.techdenovoapp.servletjsphibernatecrud.domain.Customer;

import java.util.List;

public interface CustomerDao {
    Long saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(Long id);
    Customer findCustomerById(Long id);
    List<Customer> findAllCustomers();
}
