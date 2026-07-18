package com.example.autodoc.dao;

import com.example.autodoc.model.Vehicle;
import java.sql.SQLException;
import java.util.List;

public interface VehicleDAO {
    void addVehicle(Vehicle vehicle) throws SQLException;
    List<Vehicle> getAllVehicles() throws SQLException;
    Vehicle getVehicleByPlate(String plateNumber) throws SQLException;
    List<Vehicle> getVehiclesByClientId(int clientId) throws SQLException;
    void updateVehicle(Vehicle vehicle) throws SQLException;
    void deleteVehicle(int id) throws SQLException;
}
