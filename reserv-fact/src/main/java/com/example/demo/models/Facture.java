package com.example.demo.models;

import lombok.Data;
import java.util.UUID;

@Data
public class Facture {
    public Facture() {
    }

    private double prix;
    private UUID reserv_ref;

    public Facture(double prix, UUID randomUUID) {
        this.prix = prix;
        this.reserv_ref = randomUUID;
    }
}
