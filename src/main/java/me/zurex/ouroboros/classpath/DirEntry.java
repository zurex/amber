package me.zurex.ouroboros.classpath;

import java.io.*;

/**
 * Created by Azure on 2017/8/1.
 * Make life more fun
 */
public class DirEntry extends Entry {

    public DirEntry(String path){
        super(path);
    }

    public byte[] readClass(String className) throws IOException{
        File classFile = new File(absDir, className);
        try {
            InputStream in = new FileInputStream(classFile);
            byte[] data = new byte[in.available()];
            in.read(data);
            in.close();
            return data;
        } catch (FileNotFoundException e){
            return null;
        }
    }
}
