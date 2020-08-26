package com.company;

public class TurnDirectionCommand extends Command {

    private boolean clockwise;

    public TurnDirectionCommand(Transport transport) {
        super(transport);
    }

    public TurnDirectionCommand(Transport transport, boolean clockwise) {
        super(transport);
        this.clockwise = clockwise;
    }

    public TurnDirectionCommand(boolean clockwise) {
        this.clockwise = clockwise;
    }

    @Override
    public boolean execute() {
        transport.orientation = clockwise ?
                Orientation.next(transport.orientation) :
                Orientation.previous(transport.orientation);
        return true;
    }

    @Override
    public String toString() {
        return "TurnDirectionCommand{}";
    }
}
