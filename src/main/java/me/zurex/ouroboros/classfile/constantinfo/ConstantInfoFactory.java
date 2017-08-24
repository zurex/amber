package me.zurex.ouroboros.classfile.constantinfo;

import me.zurex.ouroboros.classfile.ClassReader;
import me.zurex.ouroboros.classfile.ConstantPool;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zurex on 2017/8/18.
 * Make life more fun
 */


public class ConstantInfoFactory {
    private static Map<Integer, ConstantInfoTag> constantInfoMap = new HashMap<>();
    static {
        for (ConstantInfoTag type: ConstantInfoTag.values()){
            constantInfoMap.put(type.getTag(), type);
        }
    }

    public static ConstantInfo getInstance(ClassReader reader, ConstantPool cp, int tag){
        ConstantInfoTag type = constantInfoMap.get(tag);
        if (null != type)
            return type.getInstance(reader, cp);
        return null;
    }

}
