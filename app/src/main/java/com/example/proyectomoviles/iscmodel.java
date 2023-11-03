package com.example.proyectomoviles;

public class iscmodel {
    String url;
    String name;
    String description;
    Double price;
    String type;
    Double ganancia;

    public iscmodel(String url, String name, String description, Double price, String type, Double ganancia) {
        this.url = url;
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
        this.ganancia = ganancia;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getGanancia() {
        return ganancia;
    }

    public void setGanancia(Double ganancia) {
        this.ganancia = ganancia;
    }
}