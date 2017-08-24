package me.zurex.ouroboros.util;

/**
 * Created by zurex on 2017/8/18.
 * Make life more fun
 */
public class Tuple<T1, T2> {
    private T1 first;
    private T2 last;

    public Tuple(T1 first, T2 last){
        this.first = first;
        this.last = last;
    }

    public T1 getFirst(){
        return first;
    }

    public T2 getLast(){
        return last;
    }
}

