package Service;

import Model.DTO.SupplierDetailsDTO;
import Model.Entity.SupplierDetails;
import Repository.SupplierRepository;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class SupplierService {
    private SupplierRepository supplierRepository;
    public SupplierService(){
        supplierRepository=new SupplierRepository();
    }
    public void addSupplier(SupplierDetailsDTO supplierDetailsDTO) throws SQLException {
        supplierRepository.addSupplier(new SupplierDetails("id",supplierDetailsDTO.getLegalName(),supplierDetailsDTO.getTradeName(),supplierDetailsDTO.getPrimaryContact(),supplierDetailsDTO.getEmergencyContact(),supplierDetailsDTO.getPhysicalAddress()));
    }

    public void deleteSupplier(String text) throws SQLException {
        supplierRepository.deleteSupplier(text);
    }

    public SupplierDetails searchSupplier(String text) throws SQLException {
        return supplierRepository.searchSupplier(text);
    }

    public void updateSupplier(SupplierDetails supplierDetails) throws SQLException {
        supplierRepository.updateSupplier(new SupplierDetails(supplierDetails.getId(),supplierDetails.getLegalName(),supplierDetails.getTradeName(),supplierDetails.getPrimaryContact(),supplierDetails.getEmergencyContact(),supplierDetails.getPhysicalAddress()));

    }

    public ObservableList getAll() throws SQLException {
        return supplierRepository.getAllSuppliers();
    }
}
