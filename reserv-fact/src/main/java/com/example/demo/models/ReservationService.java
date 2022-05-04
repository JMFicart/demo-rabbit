package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class ReservationService {

    private final List<Reservation> list = new ArrayList<>();

    public abstract void create(Reservation reservation);

    public abstract void setToFacture(UUID ref);

    public abstract List<Reservation> getReserveFactures();

}
