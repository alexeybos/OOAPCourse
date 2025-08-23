package org.skillsmart.lesson9_fix;

import java.util.List;

public class PowerSet<T> extends HashTable<T> {

    private Class clazz;
    private int maxSize;

    public PowerSet(Class clz, int max_size) {
        super(clz, max_size);
        this.clazz = clz;
        this.maxSize = max_size;
    }

    public PowerSet<T> Intersection(PowerSet<T> set) {
        PowerSet<T> result = new PowerSet<T>(clazz, maxSize);
        List<T> valuesFromSet2 = set.getValues();
        for (T t : valuesFromSet2) {
            if (this.get(t)) result.put(t);
        }
        return result;
    }

    public PowerSet<T> Union(PowerSet<T> set) {
        PowerSet<T> result = new PowerSet<T>(clazz, maxSize);
        List<T> valuesFromSet1 = this.getValues();
        List<T> valuesFromSet2 = set.getValues();
        for (T t : valuesFromSet1) {
            result.put(t);
        }
        for (T t : valuesFromSet2) {
            result.put(t);
        }
        return result;
    }

    public PowerSet<T> Difference(PowerSet<T> set) {
        PowerSet<T> result = new PowerSet<T>(clazz, maxSize);
        List<T> valuesFromSet1 = this.getValues();
        for (T t: valuesFromSet1) {
            if (!set.get(t)) result.put(t);
        }
        return result;
    }

    public boolean IsSubset(PowerSet<T> set) {
        PowerSet<T> resultDifference = set.Difference(this);
        return resultDifference.size() == 0;
    }
}
