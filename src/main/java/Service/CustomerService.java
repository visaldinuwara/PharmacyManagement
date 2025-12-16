package Service;

import Model.DTO.CustomerDetailDTO;
import Model.Entity.CustomerDetails;
import Repository.CustomerRepository;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class CustomerService {
    private CustomerRepository customerRepository;
    public CustomerService(){
        customerRepository=new CustomerRepository();
    }
    public void addCustomer(CustomerDetailDTO customerDetailDTO) throws SQLException {
        String id="1";
        customerRepository.addCustomer(new CustomerDetails(id,customerDetailDTO.getFirstName(),customerDetailDTO.getLastName(),customerDetailDTO.getEmailAddress(),customerDetailDTO.getPhoneNo()));
    }

    public void deleteCustomer(String text) throws SQLException {
        customerRepository.deleteCustomer(text);
    }

    public CustomerDetails searchCustomer(String text) throws SQLException {
        return customerRepository.searchCustomer(text);
    }

    public void updateCustomer(CustomerDetails customerDetail) throws SQLException {
        customerRepository.updateCustomer(new CustomerDetails(customerDetail.getId(),customerDetail.getFirstName(),customerDetail.getLastName(),customerDetail.getEmailAddress(),customerDetail.getPhoneNo()));
    }

    public ObservableList getAllCustomer() throws SQLException {
        return customerRepository.getAllCustomers();
    }
}
