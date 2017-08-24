package me.zurex.ouroboros.classfile.constantinfo;

import me.zurex.ouroboros.classfile.ClassReader;
import me.zurex.ouroboros.classfile.ConstantPool;

/**
 * Created by zurex on 2017/8/18.
 * Make life more fun
 */
public enum ConstantInfoTag {
    UTF8(1){
        ConstantInfo getInstance(ClassReader reader, ConstantPool cp){
            return new ConstantUTF8Info(reader, this);
        }
    },
    INTEGER(3){
        ConstantInfo getInstance(ClassReader reader, ConstantPool cp){
            return new ConstantIntegerInfo(reader);
        }
    },
    FLOAT(4){
        ConstantInfo getInstance(ClassReader reader, ConstantPool cp){
            return new ConstantFloatInfo(reader);
        }
    },
    LONG(5){
        ConstantInfo getInstance(ClassReader reader, ConstantPool cp){
            return new ConstantLongInfo(reader);
        }
    },
    DOUBLE(6){
        ConstantInfo getInstance(ClassReader reader, ConstantPool cp){
            return new ConstantDoubleInfo(reader);
        }
    },
    CLAZZ(7){
        ConstantInfo getInstance(ClassReader reader, ConstantPool cp){
            return new ConstantClassInfo(reader, cp);
        }
    },
    STRING(8){
        ConstantInfo getInstance(ClassReader reader, ConstantPool cp){
            return new ConstantStringInfo(reader, cp);
        }
    },
    FIELD_REF(9){
        ConstantInfo getInstance(ClassReader reader, ConstantPool cp){
            return null;
        }
    },
    METHOD_REF(10){
        ConstantInfo getInstance(ClassReader reader, ConstantPool cp){
            return null;
        }
    },
    INTERFACE_METHOD_REF(11){
        ConstantInfo getInstance(ClassReader reader, ConstantPool cp){
            return null;
        }
    },
    NAME_AND_TYPE(12){
        ConstantInfo getInstance(ClassReader reader, ConstantPool cp){
            return new ConstantNameAndTypeInfo(reader, cp);
        }
    },
    METHOD_HANDLE(15){
        ConstantInfo getInstance(ClassReader reader, ConstantPool cp){
            return null;
        }
    },
    METHOD_TYPE(16){
        ConstantInfo getInstance(ClassReader reader, ConstantPool cp){
            return null;
        }
    },
    INVOKE_DYNAMIC(18){
        ConstantInfo getInstance(ClassReader reader, ConstantPool cp){
            return null;
        }
    },
    ;

    private int tag;

    ConstantInfoTag(int tag){
        this.tag = tag;
    }

    public int getTag(){
        return tag;
    }

    abstract ConstantInfo getInstance(ClassReader reader, ConstantPool cp);
}
