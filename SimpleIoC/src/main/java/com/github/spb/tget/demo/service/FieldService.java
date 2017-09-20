package com.github.spb.tget.demo.service;

import java.util.ArrayList;
import java.util.List;

public class FieldService implements GameService {

    public String getName() {
        return "Field service with wide space to play sport games";
    }

    public List<String> getEquipment() {
        List<String> equipments = new ArrayList<String>();
        equipments.add("Court");
        equipments.add("Net");
        return equipments;
    }
}
