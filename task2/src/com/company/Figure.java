package com.company;

public class Figure {

    private Orientation orientation;
    private Field field;
    private Position position;
    private CommandFactory factory;

    public Figure(Position position, Field field, Orientation orientation, CommandFactory factory) {
        this.position = position;
        this.field = field;
        this.orientation = orientation;
        this.factory = factory;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Field getField() {
        return field;
    }

    public Position getPosition() {
        return position;
    }

    public CommandFactory getFactory() {
        return factory;
    }

}
