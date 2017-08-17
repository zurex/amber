package me.zurex.ouroboros;

import me.zurex.ouroboros.classpath.ClassPath;

import java.io.IOException;

/**
 * Created by Azure on 2017/7/30.
 * Make life more fun
 */
public class JavaVirtualMachine {

    public static void startJVM(Command command){
        ClassPath cp = ClassPath.parse(command.getXjreOption(), command.getCpOption());
        String className = command.getClazz().replace(".", "/");
        try {
            byte[] data = cp.readClass(className);
            System.out.println("read data length:"+data.length);
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        Command command = Command.parseCommand(args);
        startJVM(command);
    }
}
