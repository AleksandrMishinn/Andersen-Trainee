package com.company.commands.factories;

import com.company.commands.commands.MoveForwardCommand;
import com.company.commands.commands.TurnLeftCommand;
import com.company.commands.commands.TurnRightCommand;

public class TransportCommandFactory extends CommandFactory {
    {
        COMMANDS.put("M", new MoveForwardCommand());
        COMMANDS.put("TR", new TurnRightCommand());
        COMMANDS.put("TL", new TurnLeftCommand());
    }
}
