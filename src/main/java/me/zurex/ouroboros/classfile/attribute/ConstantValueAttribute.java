package me.zurex.ouroboros.classfile.attribute;

/**
 * Created by zurex on 2017/8/24.
 * Make life more fun
 */

import me.zurex.ouroboros.classfile.ClassReader;
import me.zurex.ouroboros.classfile.ConstantPool;

/**
 * ConstantValue:
 *
 */
public class ConstantValueAttribute implements AttributeInfo {
    private int constantValueIndex;

    public ConstantValueAttribute(ClassReader reader){
        constantValueIndex = reader.readUint16();
    }

    public int getConstantValueIndex(){
        return constantValueIndex;
    }
}
