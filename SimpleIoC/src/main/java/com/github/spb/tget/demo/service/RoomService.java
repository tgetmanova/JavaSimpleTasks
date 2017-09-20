package com.github.spb.tget.demo.service;

import java.util.ArrayList;
import java.util.List;

public class RoomService implements GameService {

    private String prettyName;

    public void setPrettyName(String prettyName) {
        this.prettyName = prettyName;
    }

    public String getName() {
        return this.prettyName;
    }

    public List<String> getEquipment() {
        List<String> equipments = new ArrayList<String>();
        equipments.add("Chair");
        equipments.add("Food");
        return equipments;
    }
}
