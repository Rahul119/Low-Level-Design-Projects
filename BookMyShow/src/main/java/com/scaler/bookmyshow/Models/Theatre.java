package com.scaler.bookmyshow.Models;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

public class Theatre extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    private String name;
    private String address;

    @OneToMany
    private List<Hall> halls = new ArrayList<>();

    @OneToMany
    private List<Show> shows = new ArrayList<>();
}
