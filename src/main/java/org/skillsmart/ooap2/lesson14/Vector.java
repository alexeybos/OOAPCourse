package org.skillsmart.ooap2.lesson14;

import java.util.ArrayList;
import java.util.List;

public class Vector<T extends General> extends General {

    private List<T> array;

    public Vector() {
        this.array = new ArrayList<T>();
    }

    public Vector(List<T> arr) {
        this.array = arr;
    }

    public void put(T val) {
        array.add(val);
    }

    public List<T> getArray() {
        return array;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <U> U add(U adding) {
        if (adding instanceof Vector) {
            return (U) addVectors((Vector<T>) adding);
        }
        return null;
    }

    public Vector<T> addVectors(Vector<T> adding) {
        if (this.size() != adding.size()) return null;

        List<T> result = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            result.add(this.array.get(i).add(adding.array.get(i)));
        }
        return new Vector<>(result);
    }

    public int size() {
        return array.size();
    }

}
