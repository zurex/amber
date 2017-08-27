package me.zurex.ouroboros.classfile.attribute;


import me.zurex.ouroboros.classfile.ClassReader;
import me.zurex.ouroboros.classfile.ConstantPool;

/**
 * Created by zurex on 2017/8/24.
 * Make life more fun
 */
public class CodeAttribute implements AttributeInfo {
    private ConstantPool cp;
    private int maxLocals;
    private int maxStack;
    private byte[] code;
    private ExceptionTableEntry[] exceptionTable;
    private AttributeInfo[] attributes;

    public CodeAttribute(ClassReader reader){
        maxStack = reader.readUint16();
        maxLocals = reader.readUint16();
        int codeLength = (int)reader.readUint32();
        code = reader.readBytes(codeLength);
        readExceptionTable(reader);
    }

    private void readExceptionTable(ClassReader reader){
        int exceptionTableLength = reader.readUint16();
        exceptionTable = new ExceptionTableEntry[exceptionTableLength];
        for (int i =0;i<exceptionTableLength;i++){
            exceptionTable[i] = new ExceptionTableEntry(
                    reader.readUint16(),
                    reader.readUint16(),
                    reader.readUint16(),
                    reader.readUint16()
            );
        }
    }

    public class ExceptionTableEntry{
        private int startPc;
        private int endPc;
        private int handlerPc;
        private int catchType;

        public ExceptionTableEntry(int startPc, int endPc, int handlerPc, int catchType){
            this.startPc = startPc;
            this.endPc = endPc;
            this.handlerPc = handlerPc;
            this.catchType = catchType;
        }
    }
}
