package Service;

import Model.DTO.PaymentDetailsDTO;
import Model.DTO.PaymentetailsDTO;
import Model.Entity.PaymentDetails;
import Repository.PaymentRepository;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class PaymentService {
    private PaymentRepository paymentRepository;
    public PaymentService(){
        paymentRepository=new PaymentRepository();
    }
    public void addPayment(PaymentDetailsDTO paymentetailsDTO) throws SQLException {
        String id="1";
        paymentRepository.addPayment(new PaymentDetails(id,paymentetailsDTO.getOrderDetailId(),paymentetailsDTO.getPaymentMethod(),paymentetailsDTO.getAmountPayed(),paymentetailsDTO.getCardType()));
    }

    public void deletePayment(String text) throws SQLException {
        paymentRepository.deletePayment(text);
    }

    public PaymentDetails searchPayment(String text) throws SQLException {
        return paymentRepository.searchPayment(text);
    }

    public void updatePayment(PaymentDetails paymentDetails) throws SQLException {
        paymentRepository.addPayment(new PaymentDetails(paymentDetails.getPaymentId(),paymentDetails.getOrderDetailId(),paymentDetails.getPaymentMethod(),paymentDetails.getAmountPayed(),paymentDetails.getCardType()));
    }

    public ObservableList getAll() throws SQLException {
        return paymentRepository.getAllPayments();
    }
}
