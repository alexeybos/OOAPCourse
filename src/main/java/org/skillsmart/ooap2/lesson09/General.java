package org.skillsmart.ooap2.lesson09;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public abstract class General extends Object {

    // обычное копирование объекта
    public void copy(General target) {
        if (target == null) throw new IllegalArgumentException("Target cannot be null");
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                field.set(target, field.get(this));
            } catch (IllegalAccessException e) {
                return;
            }
        }
    }

    //Глубокое копирование
    public void deepCopy(General target) {
        if (target.instanceOf(General.class)) {
            System.out.println("instanceof General. return");
            return;
        }
        for (Field field : this.getClass().getDeclaredFields()) {
            System.out.println("to deep");
            field.setAccessible(true);
            try {
                Object value = field.get(this);
                if (value.getClass().isPrimitive() || !value.getClass().isAssignableFrom(General.class)) {
                    field.set(target, value);
                } else {
                    deepCopy((General) value);
                }
            } catch (IllegalAccessException e) {
                return;
            }
        }
    }

    public General clone() {
        try {
            General clonedObj = this.getClass().getDeclaredConstructor().newInstance();
            deepCopy(clonedObj);
            return clonedObj;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            return null;
        }
    }

    public boolean equal(General object) {
        return Objects.equals(this, object);
    }

    public boolean deepEqual(General object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object thisValue = field.get(this);
                Object otherValue = field.get(object);
                if (!thisValue.equals(otherValue)) {
                    return false;
                }
            } catch (IllegalAccessException e) {
                return false;
            }
        }
        return true;
    }

    public byte[] serialize(General object) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(object);
        oos.flush();
        oos.close();
        baos.close();
        return baos.toByteArray();
    }

    public General deserialize(byte[] byteData) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bais = new ByteArrayInputStream(byteData);
        Object object = new ObjectInputStream(bais).readObject();
        return (General) object;
    }

    public String print() {
        return this.toString();
    }

    public boolean instanceOf(Class<?> valueType) {
        return this.getClass() == valueType;
    }

    public Class<? extends General> getType() {
        return this.getClass();
    };
}
