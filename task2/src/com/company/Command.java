package com.company;

public abstract class Command {

    public CommandPanel commandPanel;

    public Command(CommandPanel commandPanel) {
        this.commandPanel = commandPanel;
    }

    public abstract boolean execute();
}
