package Serialization.serializerHandler;

import Serialization.ExceptionHandling.BirdErrorHandler;
import Serialization.HelperFunction.Bird;
import Serialization.Interface.SerializerInterface;

import java.io.*;
import java.util.Objects;

public class BirdSerialzer implements SerializerInterface {
    @Override
    public Bird read(FileInputStream fileInputStream) {
        Bird bird = null;
        try{
            BirdErrorHandler.fileNotExist(fileInputStream);
            ObjectInputStream in = new ObjectInputStream(fileInputStream);
            bird = (Bird) in.readObject();
            fileInputStream.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
       return bird;
    }

    @Override
    public void write(FileOutputStream fileOutputStream,Bird bird) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        out.writeObject(bird);
        out.close();
    }

    @Override
    public void log(String message) {
        SerializerInterface.super.log(message);
    }
}