package com.example.demo.models;

import lombok.Data;

import java.util.UUID;

@Data
public class Facture {

    private double prix;
    private UUID reserv_ref;

}