package com.company;

public class NaturalObjects extends Figure {

    public NaturalObjects(Position position, Field field, Orientation orientation, CommandFactory factory) {
        super(position, field, orientation, factory);
    }

    public NaturalObjects() {
        this(new Position(5, 5), new Field(10, 10), Orientation.WEST, new NatureCommandFactory());
    }
}
