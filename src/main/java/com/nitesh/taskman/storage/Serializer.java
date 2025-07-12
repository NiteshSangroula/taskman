package com.nitesh.taskman.storage;

import java.io.IOException;

public interface Serializer<T> {
    void save(T object, String filePath) throws IOException;

    T load(String filePath) throws IOException, ClassNotFoundException;

    
}
