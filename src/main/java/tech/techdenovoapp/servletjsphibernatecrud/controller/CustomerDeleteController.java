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
@WebServlet(value = "customer/delete")
public class CustomerDeleteController extends HttpServlet {
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
        Customer customer=new Customer();
        Long id = Long.parseLong(customerId);
        customer.setId(id);
        customerDao.deleteCustomer(id);
        resp.sendRedirect(req.getContextPath()+ "/");
    }
}
