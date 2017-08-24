package me.zurex.ouroboros.classfile.constantinfo;

import me.zurex.ouroboros.classfile.ClassReader;

/**
 * Created by zurex on 2017/8/18.
 * Make life more fun
 */
public class ConstantDoubleInfo implements ConstantInfo {
    double val;
    byte tag;

    public ConstantDoubleInfo(ClassReader reader){
        val = (double) reader.readUint64();
    }

    public Object getValue(){
        return val;
    }
}
