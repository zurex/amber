package me.zurex.ouroboros.classfile.attribute;


import me.zurex.ouroboros.classfile.ClassReader;
import me.zurex.ouroboros.classfile.ConstantPool;

/**
 * Created by zurex on 2017/8/24.
 * Make life more fun
 */
public class LineNumberTableAttribute implements AttributeInfo {
    private LineNumberTableEntry[] lineNumberTable;

    public LineNumberTableAttribute(ClassReader reader){
        int lineNumberTableLength = reader.readUint16();
        lineNumberTable = new LineNumberTableEntry[lineNumberTableLength];

        for (int i =0;i<lineNumberTableLength;i++){
            lineNumberTable[i] = new LineNumberTableEntry(
                    reader.readUint16(),
                    reader.readUint16()
            );
        }
    }

    public class LineNumberTableEntry{
        private int startPc;
        private int lineNumber;

        public LineNumberTableEntry(int startPc, int lineNumber){
            this.startPc = startPc;
            this.lineNumber = lineNumber;
        }
    }
}
