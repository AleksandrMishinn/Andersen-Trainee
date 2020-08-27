package com.company;

public abstract class Command {

    private Figure figure;

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public abstract boolean execute() throws EndOfFieldException;
}
