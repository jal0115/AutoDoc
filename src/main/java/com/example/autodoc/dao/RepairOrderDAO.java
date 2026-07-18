package com.example.autodoc.dao;

import com.example.autodoc.model.RepairOrder;
import com.example.autodoc.model.RepairStatus;
import java.sql.SQLException;
import java.util.List;

public interface RepairOrderDAO {
    void addRepairOrder(RepairOrder order) throws SQLException;
    List<RepairOrder> getAllRepairOrders() throws SQLException;
    List<RepairOrder> getRepairOrdersByVehicleId(int vehicleId) throws SQLException;
    void updateStatus(int id, RepairStatus status) throws SQLException;
    void deleteRepairOrder(int id) throws SQLException;
}
