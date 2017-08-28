package me.zurex.ouroboros.instruction;

import me.zurex.ouroboros.rtdata.Frame;

/**
 * Created by zurex on 2017/8/27.
 * Make life more fun
 */
public interface Instruction {
    void fetchOperands(BytecodeReader reader);
    void execute(Frame frame);
}
