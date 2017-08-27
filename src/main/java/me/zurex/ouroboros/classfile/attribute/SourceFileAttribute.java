package me.zurex.ouroboros.classfile.attribute;

import me.zurex.ouroboros.classfile.ClassReader;
import me.zurex.ouroboros.classfile.ConstantPool;

/**
 * Created by zurex on 2017/8/24.
 * Make life more fun
 */
public class SourceFileAttribute implements AttributeInfo {
    private ConstantPool cp;
    private int sourceFileIndex;

    public SourceFileAttribute(ClassReader reader, ConstantPool cp){
        this.cp = cp;
        this.sourceFileIndex = reader.readUint16();
    }

    public String getFileName(){
        return cp.getUtf8(sourceFileIndex);
    }
}
