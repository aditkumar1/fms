package com.expert_coder.entity;

public enum Priority {

    HIGH("High", 1), MEDIUM("Medium", 2), LOW("Low", 3);
    private String name;
    private int id;

    Priority(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
