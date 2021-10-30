package file_demo;

import java.io.*;
import java.nio.ByteBuffer;

public class BinFileRead {
    public static void main(String[] args) {
        File datas = new File("datas");

        try{
            FileInputStream fileInputStream = new FileInputStream(datas + "/xy.bin");
//            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            byte[] a = new byte[4];
            int b;
            while ( (b = fileInputStream.read(a)) != -1){

//                float aFloat = ByteBuffer.wrap(a).getFloat();

                float anInt = ByteBuffer.wrap(a).getFloat();

                System.out.println(anInt);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
