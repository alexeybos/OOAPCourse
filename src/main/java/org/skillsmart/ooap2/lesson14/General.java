package org.skillsmart.ooap2.lesson14;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

class General implements Serializable {

    // либо со статусами
    public static <T> General assignmentAttempt(General target, T source) {
        if (target.getClass().isAssignableFrom(source.getClass())) {
            return (General) source;
        }
        return null; //new None();
    }

    public <T> void deepCopy(T target) throws Exception {
        try {
            target = getCopy();
        } catch (Exception e) {
            throw e;
        }
    }

    public <T> T add(T adding) {
        throw new UnsupportedOperationException(
                "Not supported. Should be overridden in subclass."
        );
    }

    public <T> T deepClone() throws Exception {
        try {
            return getCopy();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public <T> String serialize() throws JsonProcessingException {
        var mapper = new ObjectMapper();
        return mapper.writeValueAsString((T)this);
    }

    public static <T> T deserialize(
            String json,
            Class<T> clazz) throws JsonProcessingException {
        var mapper = new ObjectMapper();
        return mapper.readValue(json, clazz);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @JsonIgnore
    public final Class<?> getType() {
        return this.getClass();
    }

    private <T> T getCopy() throws Exception  {
        try {
            var byteArrayOutputStream = new ByteArrayOutputStream();
            var objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject((T)this);
            var bais = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            var objectInputStream = new ObjectInputStream(bais);

            return (T) objectInputStream.readObject();
        }
        catch (Exception e) {
            throw e;
        }
    }

}

