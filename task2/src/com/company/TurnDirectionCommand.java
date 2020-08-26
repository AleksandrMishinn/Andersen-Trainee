package com.company;

public class TurnDirectionCommand extends Command {

    private boolean clockwise;

    public TurnDirectionCommand(CommandPanel commandPanel) {
        super(commandPanel);
    }

    public TurnDirectionCommand(CommandPanel commandPanel, boolean clockwise) {
        super(commandPanel);
        this.clockwise = clockwise;
    }

    @Override
    public boolean execute() {
        commandPanel.transport.orientation = clockwise ?
                Orientation.next(commandPanel.transport.orientation) :
                Orientation.previous(commandPanel.transport.orientation);
        return true;
    }

    @Override
    public String toString() {
        return "TurnDirectionCommand{}";
    }
}
