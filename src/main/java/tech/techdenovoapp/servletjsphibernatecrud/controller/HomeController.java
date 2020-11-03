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
import java.util.List;

@WebServlet(value = "/")
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private CustomerDao customerDao = new CustomerDaoImpl();

    public HomeController(){}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customers = customerDao.findAllCustomers();
        req.setAttribute("customerList", customers);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
