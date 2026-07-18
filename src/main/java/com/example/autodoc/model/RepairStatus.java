package com.example.autodoc.model;

public enum RepairStatus {
    PENDING("Хүлээгдэж буй"),
    IN_PROGRESS("Засагдаж буй"),
    DONE("Дууссан");

    private final String displayName;

    RepairStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
