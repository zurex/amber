package me.zurex.ouroboros.classfile.attribute;

import me.zurex.ouroboros.classfile.ClassReader;
import me.zurex.ouroboros.classfile.ConstantPool;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zurex on 2017/8/24.
 * Make life more fun
 */
public class AttributeInfoFactory {
    private static Map<String, AttributeInfoType> infoTypeMap = new HashMap<>();
    static {
        for (AttributeInfoType infoType : AttributeInfoType.values()){
            infoTypeMap.put(infoType.getType(), infoType);
        }
    }

    public static AttributeInfo getInstance(ClassReader reader, ConstantPool cp){
        int attrNameIndex = reader.readUint16();
        String attrName = cp.getUtf8(attrNameIndex);
        long attrLen = reader.readUint32();
        AttributeInfoType infoType = infoTypeMap.get(attrName);
        if (null != infoType)
            return infoType.getInstance(reader, cp, attrLen);
        return null;
    }
}
