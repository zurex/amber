package me.zurex.ouroboros.classfile;

import me.zurex.ouroboros.classfile.constantinfo.ConstantInfo;
import me.zurex.ouroboros.classfile.constantinfo.ConstantInfoFactory;
import me.zurex.ouroboros.classfile.constantinfo.ConstantStringInfo;
import me.zurex.ouroboros.util.Tuple;

/**
 * Created by zurex on 2017/8/15.
 * Make life more fun
 */
public class ConstantPool {
    private ConstantInfo[] constantInfo;

    private ConstantPool(ConstantInfo[] info){
        this.constantInfo = info;
    }

    public static ConstantPool getConstantPool(ClassReader reader){
        int cpCount = reader.readUint16();
        ConstantInfo[] infos = new ConstantInfo[cpCount];
        for (int i=0;i<cpCount;i++){
            infos[i] = initConstantInfo(reader, new ConstantPool(infos));
        }
        return new ConstantPool(infos);
    }

    public String getUtf8(int index){
        ConstantStringInfo info = (ConstantStringInfo)constantInfo[index];
        return info.getString();
    }

    public String getClassName(char index){
        return null;
    }

    public ConstantInfo getConstantInfo(char index){
        return constantInfo[index];
    }

    public Tuple<String, String> getNameAndType(){
        return null;
    }

    private static ConstantInfo initConstantInfo(ClassReader reader, ConstantPool cp){
        int tag = reader.readByte();
        return ConstantInfoFactory.getInstance(reader, cp, tag);
    }
}
