package me.zurex.ouroboros;

import org.apache.commons.cli.*;

import java.util.Arrays;

/**
 * Created by Azure on 2017/7/30.
 * Make life more fun
 */
public class Command {
    private boolean helpFlag;
    private boolean versionFlag;
    private String cpOption;
    private String xjreOption;
    private String clazz;
    private String[] args;

    private Command(String clazz, String[] args){
        this.clazz = clazz;
        this.args = args;
    }

    public static Command parseCommand(String[] args){
        Command command = null;
        if (args.length > 0){
            String clazz = args[0];
            command = new Command(clazz, Arrays.copyOfRange(args, 1, args.length));
        }
        Options options = new Options();
        options.addOption("h", false, "show help info");
        options.addOption("classpath", true, "class path");
        options.addOption("Xjre", true, "Xjre option");
        options.addOption("v", false, "show version");
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmdLine = parser.parse(options, args);
            if (cmdLine.hasOption("h")){
                HelpFormatter hf = new HelpFormatter();
                hf.printHelp("Options", options);
            }
            if (cmdLine.hasOption("v")){

            }
            if (cmdLine.hasOption("classpath")){
                command.cpOption = cmdLine.getOptionValue("classpath");
            }
        } catch (ParseException e){

        }
        return command;
    }

    public String getClazz(){
        return clazz;
    }

    public String getCpOption(){
        return cpOption;
    }

    public String getXjreOption(){
        return xjreOption;
    }
}
