package Serialization.ExceptionHandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BirdErrorHandler{
    public static void fileNotExist(FileInputStream fileInputStream) throws HandleErrors {
        if(fileInputStream == null) throw new HandleErrors("File Not Exist");
    }
}