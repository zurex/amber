package me.zurex.ouroboros.rtdata;

/**
 * Created by zurex on 2017/8/27.
 * Make life more fun
 */
public class OperandStack extends SlotTable {
    private int index = 0;

    public void pushInt(int value){
        setInt(index, value);
        index++;
    }

    public int popInt(){
        int value = getInt(index);
        index--;
        return value;
    }

    public void pushDouble(double value){
        setDouble(index, value);
        index++;
    }

    public void pushRef(JavaObject ref){
        setRef(index, ref);
        index++;
    }
}
