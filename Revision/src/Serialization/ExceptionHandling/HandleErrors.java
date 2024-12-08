package Serialization.ExceptionHandling;

import Serialization.Interface.SerializerInterface;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class HandleErrors extends Exception  {
    HandleErrors(String mssg){
        super(mssg);
    }

}
