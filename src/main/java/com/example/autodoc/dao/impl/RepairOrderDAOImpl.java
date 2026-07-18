package com.example.autodoc.dao.impl;

import com.example.autodoc.dao.RepairOrderDAO;
import com.example.autodoc.model.RepairOrder;
import com.example.autodoc.model.RepairStatus;
import com.example.autodoc.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepairOrderDAOImpl implements RepairOrderDAO {

    @Override
    public void addRepairOrder(RepairOrder order) throws SQLException {
        String sql = "INSERT INTO repair_orders (vehicle_id, description, mechanic_fee, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, order.getVehicleId());
            stmt.setString(2, order.getDescription());
            stmt.setDouble(3, order.getMechanicFee());
            stmt.setString(4, order.getStatus().name());
            stmt.executeUpdate();
        }
    }

    @Override
    public List<RepairOrder> getAllRepairOrders() throws SQLException {
        List<RepairOrder> orders = new ArrayList<>();
        String sql = "SELECT * FROM repair_orders ORDER BY created_at DESC";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                orders.add(mapResultSet(rs));
            }
        }
        return orders;
    }

    @Override
    public List<RepairOrder> getRepairOrdersByVehicleId(int vehicleId) throws SQLException {
        List<RepairOrder> orders = new ArrayList<>();
        String sql = "SELECT * FROM repair_orders WHERE vehicle_id = ? ORDER BY created_at DESC";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, vehicleId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                orders.add(mapResultSet(rs));
            }
        }
        return orders;
    }

    @Override
    public void updateStatus(int id, RepairStatus status) throws SQLException {
        String sql = "UPDATE repair_orders SET status = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, status.name());
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteRepairOrder(int id) throws SQLException {
        String sql = "DELETE FROM repair_orders WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    private RepairOrder mapResultSet(ResultSet rs) throws SQLException {
        RepairOrder order = new RepairOrder();
        order.setId(rs.getInt("id"));
        order.setVehicleId(rs.getInt("vehicle_id"));
        order.setDescription(rs.getString("description"));
        order.setMechanicFee(rs.getDouble("mechanic_fee"));
        order.setStatus(RepairStatus.valueOf(rs.getString("status")));
        order.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        return order;
    }
}
