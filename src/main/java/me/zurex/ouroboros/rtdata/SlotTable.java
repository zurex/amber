package me.zurex.ouroboros.rtdata;

/**
 * Created by zurex on 2017/8/27.
 * Make life more fun
 */
public class SlotTable {
    protected Slot[] slots;

    public void setInt(int index,int value){
        slots[index].setNum(value);
    }

    public int getInt(int index){
        return slots[index].getNum();
    }

    public void setFloat(int index, float value){
        int intValue = Float.floatToIntBits(value);
        setInt(index, intValue);
    }

    public float getFloat(int index){
        int value = getInt(index);
        return Float.intBitsToFloat(value);
    }

    public void setLong(int index, long value){
        int high = (int)value;
        int low = (int)(value>>32);
        setInt(index, high);
        setInt(index+1, low);
    }

    public long getLong(int index){
        int low = getInt(index);
        int high = getInt(index+1);
        return (long)high <<32 | (long)low;
    }

    public void setDouble(int index, double value){
        long longValue = Double.doubleToLongBits(value);
        setLong(index, longValue);
    }

    public double getDouble(int index){
        long value = getLong(index);
        return Double.longBitsToDouble(value);
    }

    public void setRef(int index, JavaObject ref){
        slots[index].setRef(ref);
    }

    public JavaObject getRef(int index){
        return getRef(index);
    }
}
