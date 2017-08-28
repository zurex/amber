package me.zurex.ouroboros.instruction;

import me.zurex.ouroboros.util.ByteReader;

/**
 * Created by zurex on 2017/8/27.
 * Make life more fun
 */
public class BytecodeReader extends ByteReader {

    public BytecodeReader(byte[] data){
        super(data);
    }

    public void reset(byte[] code, int pc){
        data = code;
        index = pc;
    }
}
