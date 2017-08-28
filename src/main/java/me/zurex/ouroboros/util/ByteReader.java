package me.zurex.ouroboros.util;

/**
 * Created by zurex on 2017/8/16.
 * Make life more fun
 */

import java.nio.ByteBuffer;

/**
 * this reader is write for read c-like data struct
 * support:
 *  int8 -> byte
 *  uint8 -> N/A -> short
 *  int16 -> short
 *  uint16 -> char
 *  int32 -> int
 *  uint32 -> N/A -> long
 *  int64 -> long
 */
public class ByteReader {
    protected byte[] data;
    protected int index = 0;

    public ByteReader(byte[] data){
        this.data = data;
    }

    public byte readByte(){
        byte b = data[index];
        index += 1;
        return b;
    }

    public byte[] readBytes(int length){
        byte[] data = new byte[length];
        for (int i=0;i<length;i++){
            data[i] = readByte();
        }
        return data;
    }

    public char readChar(){
        ByteBuffer buffer = ByteBuffer.allocate(Character.BYTES);
        buffer.put(readBytes(Character.BYTES));
        buffer.flip();
        return buffer.getChar();
    }

    public int readInt(){
        ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
        buffer.put(readBytes(Integer.BYTES));
        buffer.flip();
        return buffer.getInt();
    }

    public char readUint16(){
        return toUint16(readBytes(2));
    }

    public int[] readUint16s(){

        return null;
    }

    public long readUint32(){
        return toUint32(readBytes(4));
    }

    public long readUint64(){
        return toUint64(readBytes(8));
    }

    protected short toUint8(byte b){
        return (short)( b & 0x0F);
    }

    protected char toUint16(byte[] data){
        return (char)( data[0]<<8 | data[1]);
    }

    protected long toUint32(byte[] data){
        ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
        buffer.put(data);
        buffer.flip();
        return buffer.getInt() & 0x0000FFFF;
    }

    protected long toUint64(byte[] data){
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.put(data);
        buffer.flip();
        return buffer.getLong();
    }
}
