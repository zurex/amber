package me.zurex.ouroboros.rtdata;

/**
 * Created by zurex on 2017/8/27.
 * Make life more fun
 */
public class Frame {
    private OperandStack stack;
    private LocalVars localVars;

    public OperandStack getOperandStack(){
        return stack;
    }

    public LocalVars getLocalVars(){
        return localVars;
    }

}
