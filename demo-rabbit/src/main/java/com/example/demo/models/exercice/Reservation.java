package com.example.demo.models.exercice;

import java.time.LocalDate;
import java.util.UUID;

public class Reservation {
    private UUID ref;
    private LocalDate arrive;
    private LocalDate depart;
    private Status status;

    public static enum Status{
        Demande,
        Facture
    }

}
