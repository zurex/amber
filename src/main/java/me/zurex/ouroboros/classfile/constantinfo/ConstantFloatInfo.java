package me.zurex.ouroboros.classfile.constantinfo;

import me.zurex.ouroboros.classfile.ClassReader;

/**
 * Created by zurex on 2017/8/18.
 * Make life more fun
 */
public class ConstantFloatInfo implements ConstantInfo {
    float val;
    byte tag;

    public ConstantFloatInfo(ClassReader reader){
        val = (float) reader.readUint32();
    }

    public Object getValue(){
        return val;
    }
}
