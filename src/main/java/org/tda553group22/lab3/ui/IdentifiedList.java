package org.tda553group22.lab3.ui;

import java.util.ArrayList;
import java.util.List;

public class IdentifiedList<T> {
    private List<T> objects = new ArrayList<>();
    private List<Integer> keys = new ArrayList<>();
    private int counter;

    public IdentifiedList(List<T> objects) {
        this.objects = objects;
        for (int i = 0; i < objects.size(); i++) {
            keys.add(i);
        }
        counter = keys.size();
    }

}
