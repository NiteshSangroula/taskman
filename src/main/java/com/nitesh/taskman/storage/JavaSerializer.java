package com.nitesh.taskman.storage;

import java.io.*;

public class JavaSerializer<T> implements Serializer<T> {

    @Override
    public void save(T object, String filePath) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(object);
        }
    }

    @Override
    public T load(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            @SuppressWarnings("unchecked")
            T obj = (T) ois.readObject();
            return obj;
        }

    }

    
}
