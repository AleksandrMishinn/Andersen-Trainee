package com.company;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private static final Map<String, Command> commands = new HashMap<>();

     static {
        commands.put("M", new MoveForwardCommand());
        commands.put("TR", new TurnDirectionCommand(true));
        commands.put("TL", new TurnDirectionCommand(false));
    }

    public static Command getCommand(String commandString){
        return commands.get(commandString.toUpperCase());
    }

}
