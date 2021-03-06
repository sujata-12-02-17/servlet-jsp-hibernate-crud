package tech.techdenovoapp.servletjsphibernatecrud.controller;

import tech.techdenovoapp.servletjsphibernatecrud.dao.CustomerDao;
import tech.techdenovoapp.servletjsphibernatecrud.daoImpl.CustomerDaoImpl;
import tech.techdenovoapp.servletjsphibernatecrud.domain.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/customer/register")
public class CustomerRegistrationController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private CustomerDao customerDao = new CustomerDaoImpl();

    public CustomerRegistrationController() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String customerId =  req.getParameter("id");
       String firstName = req.getParameter("fName");
       String lastName =  req.getParameter("lName");
       String email = req.getParameter("email");

       Customer customer = new Customer(firstName, lastName, email);
        if (customerId == null || customerId.isEmpty()){
            customerDao.saveCustomer(customer);
        } else {
            Long id = Long.parseLong(customerId);
            customer.setId(id);
            customerDao.updateCustomer(customer);
        }
        resp.sendRedirect(req.getContextPath()+ "/");
    }
}
