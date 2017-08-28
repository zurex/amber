package me.zurex.ouroboros.rtdata;

/**
 * Created by zurex on 2017/8/27.
 * Make life more fun
 */
public class JavaThread {
    private int pc;
    private JavaStack stack;

    public JavaThread(int pc, JavaStack stack) {
        this.pc = pc;
        this.stack = stack;
    }

    public JavaStack getStack(){
        return stack;
    }

    public int getPc(){
        return pc;
    }

    public void pushFrame(Frame frame){
        stack.push(frame);
    }

    public Frame getFrame(){
        return stack.pop();
    }

    public Frame currentFrame(){
        return stack.peek();
    }
}
