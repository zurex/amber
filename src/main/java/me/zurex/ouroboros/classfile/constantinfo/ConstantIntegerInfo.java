package me.zurex.ouroboros.classfile.constantinfo;

import me.zurex.ouroboros.classfile.ClassReader;

/**
 * Created by zurex on 2017/8/18.
 * Make life more fun
 */
public class ConstantIntegerInfo implements ConstantInfo {
    int val;
    byte tag;

    public ConstantIntegerInfo(ClassReader reader){
        val = (int)reader.readUint32();
    }

    public Object getValue(){
        return val;
    }
}
