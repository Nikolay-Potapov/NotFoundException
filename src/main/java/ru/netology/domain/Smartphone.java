package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int id, String name, int cost, String manufacturer) {
        super(id, name, cost);
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (search.equalsIgnoreCase(manufacturer)) {
            return true;
        }
        return false;
    }
}
