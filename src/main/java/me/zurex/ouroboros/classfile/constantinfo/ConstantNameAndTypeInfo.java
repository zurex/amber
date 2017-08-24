package me.zurex.ouroboros.classfile.constantinfo;

import me.zurex.ouroboros.classfile.ClassReader;
import me.zurex.ouroboros.classfile.ConstantPool;

/**
 * Created by zurex on 2017/8/18.
 * Make life more fun
 */
public class ConstantNameAndTypeInfo implements ConstantInfo {
    private ConstantPool cp;
    char nameIndex;
    char descriptorIndex;
    byte tag;

    public ConstantNameAndTypeInfo(ClassReader reader, ConstantPool cp){
        nameIndex = reader.readUint16();
        descriptorIndex = reader.readUint16();
        this.cp = cp;
    }

    public Object getValue(){
        return null;
    }
}
