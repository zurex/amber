package me.zurex.ouroboros.instruction;

/**
 * Created by zurex on 2017/8/28.
 * Make life more fun
 */
public abstract class Index16Instruction implements Instruction {
    protected int index;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        index = reader.readUint16();
    }
}
