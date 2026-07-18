package com.example.autodoc.model;

import java.time.LocalDateTime;

public class RepairOrder {

    private int id;
    private int vehicleId;
    private String description;
    private double mechanicFee;
    private RepairStatus status;
    private LocalDateTime createdAt;

    public RepairOrder() {}

    public RepairOrder(int id, int vehicleId, String description, double mechanicFee, RepairStatus status, LocalDateTime createdAt) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.description = description;
        this.mechanicFee = mechanicFee;
        this.status = status;
        this.createdAt = createdAt;
    }

    public RepairOrder(int vehicleId, String description, double mechanicFee) {
        this.vehicleId = vehicleId;
        this.description = description;
        this.mechanicFee = mechanicFee;
        this.status = RepairStatus.PENDING;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getVehicleId() { return vehicleId; }
    public void setVehicleId(int vehicleId) { this.vehicleId = vehicleId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getMechanicFee() { return mechanicFee; }
    public void setMechanicFee(double mechanicFee) { this.mechanicFee = mechanicFee; }

    public RepairStatus getStatus() { return status; }
    public void setStatus(RepairStatus status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
