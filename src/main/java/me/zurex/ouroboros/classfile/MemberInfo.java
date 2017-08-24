package me.zurex.ouroboros.classfile;

/**
 * Created by zurex on 2017/8/15.
 * Make life more fun
 */

import me.zurex.ouroboros.classfile.attribute.AttributeInfo;

/**
 * member info is designed for class member like filed, method
 */
public class MemberInfo {
    private ConstantPool cp;
    private char accessFlags;
    private char nameIndex;
    private char descriptorIndex;
    private AttributeInfo[] attributes;

    private MemberInfo(
            ConstantPool cp,
            char accessFlags,
            char nameIndex,
            char descriptorIndex,
            AttributeInfo[] attributes
    ){
        this.cp = cp;
        this.accessFlags = accessFlags;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.attributes = attributes;

    }

    private static MemberInfo[] getMembers(ClassReader reader, ConstantPool cp){
        int memberCount = reader.readUint16();
        MemberInfo[] members = new MemberInfo[memberCount];
        for (int i=0;i<memberCount;i++){
            members[i] = getMember(reader, cp);
        }
        return members;
    }

    public char getAccessFlags(){
        return accessFlags;
    }

    public String getName(){
        return cp.getUtf8(nameIndex);
    }

    public String getDescriptor(){
        return cp.getUtf8(descriptorIndex);
    }

    public static MemberInfo getMember(ClassReader reader, ConstantPool cp){
        return new MemberInfo(
                cp,
                reader.readUint16(),
                reader.readUint16(),
                reader.readUint16(),
                getAttributes(reader, cp)
        );
    }

    private static AttributeInfo[] getAttributes(ClassReader reader, ConstantPool cp){
        return null;
    }
}
