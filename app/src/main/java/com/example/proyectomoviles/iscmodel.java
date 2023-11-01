package com.example.proyectomoviles;

public class iscmodel {
    String url;
    String name;
    String description;
    String price;
    String type;
    String ganancia;

    public iscmodel(String url, String name, String description, String price, String type, String ganancia) {
        this.url = url;
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
        this.ganancia = ganancia;
    }

    public String getGanancia() {
        return ganancia;
    }

    public void setGanancia(String ganancia) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
