package com.example.autodoc.model;

public class Vehicle {

    private int id;
    private String plateNumber;
    private String brand;
    private String model;
    private int clientId;

    public Vehicle() {}

    public Vehicle(int id, String plateNumber, String brand, String model, int clientId) {
        this.id = id;
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.model = model;
        this.clientId = clientId;
    }

    public Vehicle(String plateNumber, String brand, String model, int clientId) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.model = model;
        this.clientId = clientId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getPlateNumber() { return plateNumber; }
    public void setPlateNumber(String plateNumber) { this.plateNumber = plateNumber; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getClientId() { return clientId; }
    public void setClientId(int clientId) { this.clientId = clientId; }

    @Override
    public String toString() {
        return plateNumber + " - " + brand + " " + model;
    }
}
