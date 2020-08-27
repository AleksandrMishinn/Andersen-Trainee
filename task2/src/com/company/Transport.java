package com.company;

public class Transport extends Figure {

    public Transport(Position position, Field field, Orientation orientation, CommandFactory factory) {
        super(position, field, orientation, factory);
    }

    public Transport() {
        this(new Position(0, 0), new Field(5, 5), Orientation.NORTH, new TransportCommandFactory());
    }
}
