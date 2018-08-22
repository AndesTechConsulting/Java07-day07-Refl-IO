package org.andestech.learning.rfb18;

import java.io.*;

public class AppIO {

    public static void main(String[] args) {

        String myCat = "C:\\Users\\and\\IdeaProjects\\data\\";

        File file1 = new File(myCat + "file1.txt");

        if (!file1.exists()) {
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

// Писатель
        try (FileWriter fw = new FileWriter(file1)) {
            //...
            fw.write("String data\r\n");
            fw.write("DATA String data\r\n");
            fw.write("Время первых. String data\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

// Читатель
        try (FileReader fr = new FileReader(file1)) {
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }}
