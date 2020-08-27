package com.company.commands.factories;

import com.company.commands.commands.Command;
import com.company.commands.exceptions.CommandNotFoundException;

import java.util.HashMap;
import java.util.Map;

public abstract class CommandFactory {

    protected final Map<String, Command> COMMANDS = new HashMap<>();

    public Command getCommand(String commandString) throws CommandNotFoundException {

        Command command = COMMANDS.get(commandString.toUpperCase());

        if (command == null) {
            throw new CommandNotFoundException();
        }

        return command;
    }

}
