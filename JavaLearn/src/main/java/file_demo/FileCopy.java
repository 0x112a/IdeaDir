package file_demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try{
             in = new FileInputStream("/home/monica/IdeaProjects/JavaLearn/src/file_demo/helloFile.java");
             out = new FileOutputStream("./testout.txt");

             byte[] buffer = new byte[10];

             int len = in.read(buffer);

             while (len != -1){
                  String copyStr = new String(buffer);

                  System.out.println(copyStr);

                  out.write(buffer,0,len);

                  len = in.read(buffer);

             }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            in.close();
            out.close();
        }
    }
}
