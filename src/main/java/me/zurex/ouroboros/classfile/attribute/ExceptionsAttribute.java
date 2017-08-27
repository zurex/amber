package me.zurex.ouroboros.classfile.attribute;


import me.zurex.ouroboros.classfile.ClassReader;
import me.zurex.ouroboros.classfile.ConstantPool;

/**
 * Created by zurex on 2017/8/24.
 * Make life more fun
 */
public class ExceptionsAttribute implements AttributeInfo {
    private ConstantPool cp;
    private int[] exceptionIndexTable;

    public ExceptionsAttribute(ClassReader reader){
        exceptionIndexTable = reader.readUint16s();
    }

    public int[] getExceptionIndexTable(){
        return exceptionIndexTable;
    }
}
