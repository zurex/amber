package me.zurex.ouroboros.instruction.constant;

import me.zurex.ouroboros.instruction.NoOperandsInstruction;
import me.zurex.ouroboros.rtdata.Frame;

/**
 * Created by zurex on 2017/8/28.
 * Make life more fun
 */
public class DConst0Instruction extends NoOperandsInstruction {
    @Override
    public void execute(Frame frame) {
        frame.getOperandStack().pushDouble(0.0F);
    }
}
