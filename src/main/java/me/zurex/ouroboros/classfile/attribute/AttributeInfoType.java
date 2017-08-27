package me.zurex.ouroboros.classfile.attribute;

import me.zurex.ouroboros.classfile.ClassReader;
import me.zurex.ouroboros.classfile.ConstantPool;

/**
 * Created by zurex on 2017/8/24.
 * Make life more fun
 */
public enum AttributeInfoType {
    CODE("code"){
        AttributeInfo getInstance(ClassReader reader, ConstantPool cp, long attrLen){
            return null;
        }
    },
    CONSTANT_VALUE("ConstantValue"){
        AttributeInfo getInstance(ClassReader reader, ConstantPool cp, long attrLen){
            return new ConstantValueAttribute(reader);
        }
    },
    DEPRECATED("Deprecated"){
        AttributeInfo getInstance(ClassReader reader, ConstantPool cp, long attrLen){
            return null;
        }
    },
    EXCEPTIONS("Exceptions"){
        AttributeInfo getInstance(ClassReader reader, ConstantPool cp, long attrLen){
            return new ExceptionsAttribute(reader);
        }
    },
    LINE_NUMBER_TABLE("LineNumberTable"){
        AttributeInfo getInstance(ClassReader reader, ConstantPool cp, long attrLen){
            return null;
        }
    },
    LOCAL_VARIABLE_TABLE("LocalVariableTable"){
        AttributeInfo getInstance(ClassReader reader, ConstantPool cp, long attrLen){
            return null;
        }
    },
    SOURCE_FILE("SourceFile"){
        AttributeInfo getInstance(ClassReader reader, ConstantPool cp, long attrLen){
            return new SourceFileAttribute(reader, cp);
        }
    },
    SYNTHETIC("Synthetic"){
        AttributeInfo getInstance(ClassReader reader, ConstantPool cp, long attrLen){
            return null;
        }
    }
    ;

    private String type;

    AttributeInfoType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

    abstract AttributeInfo getInstance(ClassReader reader, ConstantPool cp, long attrLen);
}
