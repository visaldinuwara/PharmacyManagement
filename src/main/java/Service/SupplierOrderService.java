package Service;

import Model.DTO.SupplierOrderDetailsDTO;
import Model.Entity.SupplierOrderDetails;
import Repository.SupplierOrderRepository;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class SupplierOrderService {
    private SupplierOrderRepository supplierOrderRepository;
    public SupplierOrderService(){
        supplierOrderRepository=new SupplierOrderRepository();
    }
    public void addSupplierOrder(SupplierOrderDetailsDTO supplierOrderDetailsDTO) throws SQLException {
        supplierOrderRepository.addSupplierOrder(new SupplierOrderDetails("1",supplierOrderDetailsDTO.getSupplierId(),supplierOrderDetailsDTO.getOrderDate(),supplierOrderDetailsDTO.getExpectedDate(),supplierOrderDetailsDTO.getTotalCost()));
    }

    public SupplierOrderDetails searchSupplierOrder(String text) throws SQLException {
        return supplierOrderRepository.searchSupplierOrder(text);
    }

    public void updateSupplierOrder(SupplierOrderDetails supplierOrderDetails) throws SQLException {
        supplierOrderRepository.updateSupplierOrder(new SupplierOrderDetails("1",supplierOrderDetails.getSupplierId(),supplierOrderDetails.getOrderDate(),supplierOrderDetails.getExpectedDate(),supplierOrderDetails.getTotalCost()));
    }

    public ObservableList getAll() throws SQLException {
        return supplierOrderRepository.getAllSupplierOrders();
    }
}
