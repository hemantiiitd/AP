package Serialization.Interface;

import Serialization.HelperFunction.Bird;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public interface SerializerInterface {
    Bird read(FileInputStream fileInputStream) throws IOException;
    void write(FileOutputStream fileOutputStream,Bird bird) throws IOException;

    default void log(String message) {
        System.out.println("Log: " + message);
    }
}
