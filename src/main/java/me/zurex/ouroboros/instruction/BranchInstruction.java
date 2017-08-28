package me.zurex.ouroboros.instruction;

/**
 * Created by zurex on 2017/8/27.
 * Make life more fun
 */
public abstract class BranchInstruction implements Instruction {
    protected int offset;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        offset = reader.readInt();
    }
}
