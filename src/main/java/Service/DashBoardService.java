package Service;

import Model.Entity.CustomerOrderDetails;
import Model.Entity.SupplierOrderDetails;
import Repository.CustomerOrderRepository;
import Repository.SupplierOrderRepository;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class DashBoardService {
    private CustomerOrderRepository customerOrderRepository;
    private SupplierOrderRepository supplierOrderRepository;
    public DashBoardService(){
        customerOrderRepository=new CustomerOrderRepository();
        supplierOrderRepository=new SupplierOrderRepository();
    }
    public double[] getOrders() throws SQLException {
        double[] valueArray=new double[11];
        ObservableList<CustomerOrderDetails>customerOrderArray= customerOrderRepository.getAllCustomerOrders();
        ObservableList<SupplierOrderDetails>supplierOrderArray=supplierOrderRepository.getAllSupplierOrders();
        if(customerOrderArray!=null || supplierOrderArray!=null) {
            for (CustomerOrderDetails customerOrder : customerOrderArray) {
                if (customerOrder.getOrderDate().substring(6, 8).equalsIgnoreCase("01")) {
                    valueArray[0] = valueArray[0] + customerOrder.getTotalAmount();
                } else if (customerOrder.getOrderDate().substring(6, 8).equalsIgnoreCase("02")) {
                    valueArray[1] = valueArray[1] + customerOrder.getTotalAmount();
                } else if (customerOrder.getOrderDate().substring(6, 8).equalsIgnoreCase("03")) {
                    valueArray[2] = valueArray[2] + customerOrder.getTotalAmount();
                } else if (customerOrder.getOrderDate().substring(6, 8).equalsIgnoreCase("04")) {
                    valueArray[3] = valueArray[3] + customerOrder.getTotalAmount();
                } else if (customerOrder.getOrderDate().substring(6, 8).equalsIgnoreCase("05")) {
                    valueArray[4] = valueArray[4] + customerOrder.getTotalAmount();
                } else if (customerOrder.getOrderDate().substring(6, 8).equalsIgnoreCase("06")) {
                    valueArray[5] = valueArray[5] + customerOrder.getTotalAmount();
                } else if (customerOrder.getOrderDate().substring(6, 8).equalsIgnoreCase("07")) {
                    valueArray[6] = valueArray[6] + customerOrder.getTotalAmount();
                } else if (customerOrder.getOrderDate().substring(6, 8).equalsIgnoreCase("08")) {
                    valueArray[7] = valueArray[7] + customerOrder.getTotalAmount();
                } else if (customerOrder.getOrderDate().substring(6, 8).equalsIgnoreCase("09")) {
                    valueArray[8] = valueArray[8] + customerOrder.getTotalAmount();
                } else if (customerOrder.getOrderDate().substring(6, 8).equalsIgnoreCase("10")) {
                    valueArray[9] = valueArray[9] + customerOrder.getTotalAmount();
                } else if (customerOrder.getOrderDate().substring(6, 8).equalsIgnoreCase("11")) {
                    valueArray[10] = valueArray[10] + customerOrder.getTotalAmount();
                } else {
                    valueArray[11] = valueArray[11] + customerOrder.getTotalAmount();
                }
            }
        for(SupplierOrderDetails supplierOrderDetails:supplierOrderArray){
            if(supplierOrderDetails.getOrderDate().substring(6,8).equalsIgnoreCase("01")){
                valueArray[0]=valueArray[0]+supplierOrderDetails.getTotalCost();
            }else if(supplierOrderDetails.getOrderDate().substring(6,8).equalsIgnoreCase("02")){
                valueArray[1]=valueArray[1]+supplierOrderDetails.getTotalCost();
            }else if(supplierOrderDetails.getOrderDate().substring(6,8).equalsIgnoreCase("03")){
                valueArray[2]=valueArray[2]+supplierOrderDetails.getTotalCost();
            } else if (supplierOrderDetails.getOrderDate().substring(6,8).equalsIgnoreCase("04")) {
                valueArray[3]=valueArray[3]+supplierOrderDetails.getTotalCost();
            } else if (supplierOrderDetails.getOrderDate().substring(6,8).equalsIgnoreCase("05")) {
                valueArray[4]=valueArray[4]+supplierOrderDetails.getTotalCost();
            } else if (supplierOrderDetails.getOrderDate().substring(6,8).equalsIgnoreCase("06")) {
                valueArray[5]=valueArray[5]+supplierOrderDetails.getTotalCost();
            } else if (supplierOrderDetails.getOrderDate().substring(6,8).equalsIgnoreCase("07")) {
                valueArray[6]=valueArray[6]+supplierOrderDetails.getTotalCost();
            } else if (supplierOrderDetails.getOrderDate().substring(6,8).equalsIgnoreCase("08")) {
                valueArray[7]=valueArray[7]+supplierOrderDetails.getTotalCost();
            } else if (supplierOrderDetails.getOrderDate().substring(6,8).equalsIgnoreCase("09")) {
                valueArray[8]=valueArray[8]+supplierOrderDetails.getTotalCost();
            } else if (supplierOrderDetails.getOrderDate().substring(6,8).equalsIgnoreCase("10")) {
                valueArray[9]=valueArray[9]+supplierOrderDetails.getTotalCost();
            } else if (supplierOrderDetails.getOrderDate().substring(6,8).equalsIgnoreCase("11")) {
                valueArray[10]=valueArray[10]+supplierOrderDetails.getTotalCost();
            }else{
                valueArray[11]=valueArray[11]+supplierOrderDetails.getTotalCost();
            }
        }
        return valueArray;
    }
        return null;
    }
}
