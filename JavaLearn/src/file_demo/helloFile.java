package file_demo;

import java.io.File;
import java.io.FilenameFilter;

public class helloFile {
    public static void main(String[] args) {

        File dir = new File("../");

        Filter filter = new Filter("html");

        System.out.println("HTML 文件目录:"+dir);

        String files[] = dir.list();

        for(String fileName:files){
            File f = new File(dir,fileName);
            if(f.isFile()){
                System.out.println("_________________________");
                System.out.println("文件名："+f.getName());
                System.out.println("文件绝对路径:"+f.getAbsolutePath());
                System.out.println("文件路径:"+f.getPath());
                System.out.println("_________________________");
            }else {
                System.out.println("_________________________");
                System.out.println("子目录:"+f);
                System.out.println("_________________________");
            }
        }
    }
}

class Filter implements FilenameFilter{
    String extent;

    @Override
    public boolean accept(File file, String s) {
        return s.endsWith("."+extent);
    }

    public Filter(String extent) {
        this.extent = extent;
    }


}
