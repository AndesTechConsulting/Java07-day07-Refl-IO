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


// Binary

        try (FileOutputStream fos =
                new FileOutputStream(myCat+"file2.txt")) {

            String data = "Нервы у Парка сжались в тугой комок. Он с трудом подавил в себе\n надвигающийся панический ужас. Сдерживая себя, он не спеша включил силовое поле, и голубой шар окутал его.\n" +
                    " Парк схватил пистолет, из которого Эдсель убил Факсона, и почувствовал,\n как удобно легла в его руку прикладистая рукоятка. Чудовище приближалось.\n Парк нажал на кнопку, и из дула вырвался прямой луч";

            byte[] arr = data.getBytes("utf8");
            fos.write(arr);

        } catch (IOException e) {
            e.printStackTrace();
        }
   // читатель

        try (FileInputStream fos =
                     new FileInputStream(myCat+"file2.txt")) {

//            String data = "Нервы у Парка сжались в тугой комок. Он с трудом подавил в себе\n надвигающийся панический ужас. Сдерживая себя, он не спеша включил силовое поле, и голубой шар окутал его.\n" +
//                    " Парк схватил пистолет, из которого Эдсель убил Факсона, и почувствовал,\n как удобно легла в его руку прикладистая рукоятка. Чудовище приближалось.\n Парк нажал на кнопку, и из дула вырвался прямой луч";

            byte[] arr = new byte[fos.available()];

            fos.read(arr);

            System.out.println(new String(arr,"utf8"));

        } catch (IOException e) {
            e.printStackTrace();
        }
// Binary

        try(DataOutputStream dos =
                new DataOutputStream(
                        new FileOutputStream(myCat+"file3.bin")))
        {
           dos.writeDouble(123.456789);
           dos.writeInt(77777777);
           dos.writeLong(28347928479287L);

        }
        catch (IOException ex){ex.printStackTrace();}


    }}
