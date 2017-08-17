package me.zurex.ouroboros.classfile;

import me.zurex.ouroboros.util.ByteReader;

import java.nio.ByteBuffer;

/**
 * Created by zurex on 2017/8/15.
 * Make life more fun
 */
public class ClassReader extends ByteReader {
    private final byte[] data;
    private int index = 0;

    public ClassReader(byte[] data){
        this.data = data;
    }

    public byte readByte(){
        byte b = data[index];
        index += 1;
        return b;
    }

    public byte[] readByte(int length){
        byte[] data = new byte[length];
        for (int i=0;i<length;i++){
            data[i] = readByte();
        }
        return data;
    }

    public char readChar(){
        ByteBuffer buffer = ByteBuffer.allocate(Character.BYTES);
        buffer.put(readByte(Character.BYTES));
        buffer.flip();
        return buffer.getChar();
    }

    public int readInt(){
        ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
        buffer.put(readByte(Integer.BYTES));
        buffer.flip();
        return buffer.getInt();
    }

    public char readUint16(){
        return toUint16(readByte(2));
    }

    public long readUint32(){
        return toUint32(readByte(4));
    }
}
