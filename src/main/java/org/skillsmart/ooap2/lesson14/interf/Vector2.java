package org.skillsmart.ooap2.lesson14.interf;

import java.util.ArrayList;
import java.util.List;

public class Vector2<T extends General2> extends General2 implements Addable<T>{
    private List<T> arr;

    public Vector2() {
        this.arr = new ArrayList<T>();
    }

    public Vector2(List<T> arr) {
        this.arr = arr;
    }

    public void addValueToVector(T val) {
        arr.add(val);
    }

    @Override
    public T add(T adding) {
        return null;
    }

    public Vector2<T> addVectors(Vector2<T> adding) {
        if (this.size() != adding.size()) return null;

        List<T> result = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            //result.add(this.arr.get(i).add(adding.arr.get(i)));
        }
        return new Vector2<>(result);
    }

    public int size() {
        return arr.size();
    }
}
