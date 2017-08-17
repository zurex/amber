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
    protected short toUint8(byte b){
        return (short)( b & 0x0F);
    }

    protected char toUint16(byte[] data){
        return (char)( data[0]<<8 & data[1]);
    }

    protected long toUint32(byte[] data){
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.put(data);
        buffer.flip();
        return buffer.getLong();
    }
}
