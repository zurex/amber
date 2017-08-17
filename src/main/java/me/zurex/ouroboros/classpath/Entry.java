package me.zurex.ouroboros.classpath;

import java.io.IOException;

/**
 * Created by Azure on 2017/8/1.
 * Make life more fun
 */
public abstract class Entry {
    protected String absDir;

    protected Entry(String path){
        this.absDir = path;
    }

    public abstract byte[] readClass(String className) throws IOException;

    public static Entry instance(String path){
        return new DirEntry(path);
    }
}
