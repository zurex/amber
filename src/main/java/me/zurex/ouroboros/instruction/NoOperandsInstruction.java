package me.zurex.ouroboros.instruction;

import me.zurex.ouroboros.rtdata.Frame;

/**
 * Created by zurex on 2017/8/27.
 * Make life more fun
 */
public class NoOperandsInstruction implements Instruction {
    @Override
    public void fetchOperands(BytecodeReader reader) {

    }

    @Override
    public void execute(Frame frame) {

    }
}
