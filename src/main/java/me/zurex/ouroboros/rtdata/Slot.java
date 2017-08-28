package me.zurex.ouroboros.rtdata;

/**
 * Created by zurex on 2017/8/27.
 * Make life more fun
 */
public class Slot {
    private int num;
    private JavaObject ref;

    public Slot(int num, JavaObject ref) {
        this.num = num;
        this.ref = ref;
    }

    public void setNum(int num){
        this.num = num;
    }

    public int getNum(){
        return num;
    }

    public void setRef(JavaObject ref){
        this.ref = ref;
    }

    public JavaObject getRef(){
        return ref;
    }
}
