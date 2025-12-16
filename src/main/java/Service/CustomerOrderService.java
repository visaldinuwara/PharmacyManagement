package Service;

import Controller.CustomerController;
import Controller.CustomerOrderController;
import Model.DTO.CustomerOrderDetailsDTO;
import Model.Entity.CustomerOrderDetails;
import Repository.CustomerOrderRepository;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class CustomerOrderService {
    private CustomerOrderRepository customerOrderRepository;
    public CustomerOrderService(){
        customerOrderRepository=new CustomerOrderRepository();
    }
    public void addCustomerOrder(CustomerOrderDetailsDTO customerOrderDetailsDTO) throws SQLException {
        String id="1";
        customerOrderRepository.addCustomerOrder(new CustomerOrderDetails(id,customerOrderDetailsDTO.getCustomerID(),customerOrderDetailsDTO.getOrderDate(),customerOrderDetailsDTO.getTotalAmount(),customerOrderDetailsDTO.getShippingAdress()));
    }

    public void deleteCustomer(String text) throws SQLException {
        customerOrderRepository.deleteCustomerOrder(text);
    }

    public CustomerOrderDetails searchCustomerOrder(String text) throws SQLException {
        return customerOrderRepository.searchCustomerOrder(text);
    }

    public void deleteCustomerOrder(CustomerOrderDetails customerOrderDetails) throws SQLException {
        customerOrderRepository.updateCustomerOrder(new CustomerOrderDetails(customerOrderDetails.getOrderId(),customerOrderDetails.getCustomerId(),customerOrderDetails.getOrderDate(),customerOrderDetails.getTotalAmount(),customerOrderDetails.getShippingAddress()));
    }

    public ObservableList getAll() throws SQLException {
        return customerOrderRepository.getAllCustomerOrders();
    }
}
