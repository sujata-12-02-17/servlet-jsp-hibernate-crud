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
import java.io.PrintWriter;

@WebServlet(value = "customer/update")
public class CustomerUpdateController  extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        String customerId =  req.getParameter("id");
        String firstName = req.getParameter("fName");
        String lastName =  req.getParameter("lName");
        String email = req.getParameter("email");


        Customer customer=new Customer(firstName,lastName,email);
        Long id = Long.parseLong(customerId);
        customer.setId(id);
        customerDao.updateCustomer(customer);
        resp.sendRedirect(req.getContextPath()+ "/");





    }
}

