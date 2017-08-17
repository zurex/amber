package me.zurex.ouroboros.classpath;

import java.io.IOException;

/**
 * Created by Azure on 2017/8/1.
 * Make life more fun
 */
public class ClassPath {
    private Entry bootClasspath;
    private Entry extClasspath;
    private Entry userClasspath;

    private ClassPath(Entry userClasspath){
        this.userClasspath = userClasspath;
    }

    public static ClassPath parse(String xjreOption, String cpOption){
        return new ClassPath(
                parseUserClasspath(cpOption)
        );
    }

    public byte[] readClass(String className) throws IOException{
        className += ".class";
        return userClasspath.readClass(className);
    }

    private static Entry parseUserClasspath(String cpOption){
        if (null == cpOption || cpOption.isEmpty()){
            cpOption = System.getProperty("user.dir");
        }
        return new DirEntry(cpOption);
    }
}
