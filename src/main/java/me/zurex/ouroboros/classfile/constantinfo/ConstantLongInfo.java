package me.zurex.ouroboros.classfile.constantinfo;

import me.zurex.ouroboros.classfile.ClassReader;

/**
 * Created by zurex on 2017/8/18.
 * Make life more fun
 */
public class ConstantLongInfo implements ConstantInfo {
    long val;
    byte tag;

    public ConstantLongInfo(ClassReader reader){
        val = (int)reader.readUint64();
    }

    public Object getValue(){
        return val;
    }
}
