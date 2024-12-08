package Serialization;

import Serialization.HelperFunction.Bird;
import Serialization.serializerHandler.BirdSerialzer;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main{
    public static void main(String[] args) {
        Bird bird = new Bird(1, 100, 200, 50, 45, 5, 10, 15);

        BirdSerialzer birdSerialzer = new BirdSerialzer();
        try {
            birdSerialzer.write(new FileOutputStream("bird.ser"), bird);
            System.out.println("File saved!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            Bird b = birdSerialzer.read(new FileInputStream("bird.ser"));
            System.out.println(b.getName());
            System.out.println("File read!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}