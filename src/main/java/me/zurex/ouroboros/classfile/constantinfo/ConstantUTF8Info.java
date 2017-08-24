package me.zurex.ouroboros.classfile.constantinfo;

import me.zurex.ouroboros.classfile.ClassReader;

/**
 * Created by zurex on 2017/8/18.
 * Make life more fun
 */
public class ConstantUTF8Info implements ConstantInfo {
    String val;
    ConstantInfoTag tag;

    public ConstantUTF8Info(ClassReader reader, ConstantInfoTag tag){
        int length = reader.readUint16();
        byte[] data = reader.readBytes(length);
        val = new String(data);
        this.tag = tag;
    }

    public Object getValue(){
        return val;
    }
}
