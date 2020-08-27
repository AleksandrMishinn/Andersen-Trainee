package com.company;

public class TransportCommandFactory extends CommandFactory {
    {
        COMMANDS.put("M", new MoveForwardCommand());
        COMMANDS.put("TR", new TurnRightCommand());
        COMMANDS.put("TL", new TurnLeftCommand());
    }
}
