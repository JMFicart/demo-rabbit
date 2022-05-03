package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facture implements Serializable {
    private String nomClient;
    private double prixTotal;
    private String adresseFacturation;
    private List<Produit> produits;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Produit{
        private String nom;
        private double prix;
    }
}
