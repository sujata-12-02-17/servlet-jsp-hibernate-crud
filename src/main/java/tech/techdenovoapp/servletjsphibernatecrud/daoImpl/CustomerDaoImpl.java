package tech.techdenovoapp.servletjsphibernatecrud.daoImpl;

import tech.techdenovoapp.servletjsphibernatecrud.dao.CustomerDao;
import tech.techdenovoapp.servletjsphibernatecrud.domain.Customer;
import tech.techdenovoapp.servletjsphibernatecrud.util.DbConnectionUtil;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {


    public Connection saveCustomer(Customer customer) {
        DbConnectionUtil dbConnectionUtil = new DbConnectionUtil();
        Connection con = dbConnectionUtil.getDbConnection();
        if (con != null) {
            try {
                PreparedStatement st = con.prepareStatement("INSERT INTO STUDENT (fName,lName,email) VALUES(?,?,?)");

                st.setString(1, customer.getfName());
                st.setString(2, customer.getlName());
                st.setString(3, customer.getEmail());
                st.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return con;
    }

    public void updateCustomer(Customer customer) {

        DbConnectionUtil dbConnectionUtil = new DbConnectionUtil();
        Connection con = dbConnectionUtil.getDbConnection();
        if (con != null) {
            try {
                PreparedStatement st = con.prepareStatement("update student set fName=?,lName=?,email=? where id=?");

                st.setString(1, customer.getfName());
                st.setString(2, customer.getlName());
                st.setString(3, customer.getEmail());
                st.setLong(4,customer.getId());

                st.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }


    public void deleteCustomer(Long id) {


        DbConnectionUtil dbConnectionUtil = new DbConnectionUtil();
        Connection con = dbConnectionUtil.getDbConnection();
        if (con != null) {
            try {
                PreparedStatement st = con.prepareStatement("delete from customer where id=?");
                {
                    st.setLong(1, id);

                    st.executeUpdate();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }

    public Connection findCustomerById(Long id) {
        Customer customer=new Customer();
        DbConnectionUtil dbConnectionUtil = new DbConnectionUtil();
        Connection con = dbConnectionUtil.getDbConnection();

        if (con != null) {
            try {
                PreparedStatement st = con.prepareStatement("select * from customer  where id=?");
                {
                    st.setLong(1, id);
                    ResultSet rs=st.executeQuery();{
                        if(rs.next()){

                        customer.setId(rs.getLong(1));
                        customer.setfName(rs.getString(2));
                        customer.setlName(rs.getString(3));
                        customer.setEmail(rs.getString(4));
                        }
                    }

                    st.executeUpdate();
                }
            } catch (SQLException e5) {
                e5.printStackTrace();
            }

        }
        return con;
    }


    public List<Customer> findAllCustomers() {

        DbConnectionUtil dbConnectionUtil = new DbConnectionUtil();
        Connection con = dbConnectionUtil.getDbConnection();
        List<Customer> customers = new ArrayList<Customer>();
        if (con != null) {
            try {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * from customer");
                while (rs.next()) {
                    Customer cust = new Customer(rs.getLong("id"), rs.getString("fname"), rs.getString("lName"), rs.getString("email"));
                    customers.add(cust);
                }

            } catch (SQLException e4) {

                e4.printStackTrace();
            }


            return customers;
        }
        return customers;
    }
}





