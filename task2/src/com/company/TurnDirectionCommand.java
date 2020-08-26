package com.company;

public class TurnDirectionCommand extends Command {

    private boolean clockwise;

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
        return "Транспорт развернулся на " + transport.orientation.getTitle();
    }
}
