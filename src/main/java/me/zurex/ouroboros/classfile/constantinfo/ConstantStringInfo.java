package me.zurex.ouroboros.classfile.constantinfo;

import me.zurex.ouroboros.classfile.ClassReader;
import me.zurex.ouroboros.classfile.ConstantPool;

/**
 * Created by zurex on 2017/8/18.
 * Make life more fun
 */
public class ConstantStringInfo implements ConstantInfo {
    private ConstantPool cp;
    private char stringIndex;
    byte tag;

    public ConstantStringInfo(ClassReader reader, ConstantPool cp){
        stringIndex = reader.readUint16();
        this.cp = cp;
    }

    public Object getValue(){
        return cp.getUtf8(stringIndex);
    }

    public String getString() {
        return (String) getValue();
    }
}
