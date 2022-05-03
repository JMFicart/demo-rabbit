package com.example.demo.models.exercice;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class FactureService {
    private List<Facture> factures = new ArrayList<>();

    public abstract void createFacture(int nbrNuit, UUID reserv_ref);

    public abstract void setToFactures();

    public abstract List<Facture> getReservFactures();
}
