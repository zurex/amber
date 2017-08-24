package me.zurex.ouroboros.classfile.constantinfo;

import me.zurex.ouroboros.classfile.ClassReader;
import me.zurex.ouroboros.classfile.ConstantPool;

/**
 * Created by zurex on 2017/8/18.
 * Make life more fun
 */
public class ConstantClassInfo implements ConstantInfo {
    private ConstantPool cp;
    char nameIndex;
    byte tag;

    public ConstantClassInfo(ClassReader reader, ConstantPool cp){
        nameIndex = reader.readUint16();
        this.cp = cp;
    }

    public Object getValue(){
        return cp.getUtf8(nameIndex);
    }

    public String getName(){
        return (String) getValue();
    }
}
