package com.example.demo.models;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class Reservation {

    private UUID ref;
    private LocalDate arrive; // on part du principe: arrivé à 12h
    private LocalDate depart; // on part du principe: départ à 12h
    private Status status;

    public static enum Status {
        DEMANDE,
        FACTURE
    }

}
