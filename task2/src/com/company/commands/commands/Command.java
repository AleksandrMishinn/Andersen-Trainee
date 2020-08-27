package com.company.commands.commands;

import com.company.entities.Figure;
import com.company.commands.exceptions.EndOfFieldException;

public abstract class Command {

    protected Figure figure;

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public abstract boolean execute() throws EndOfFieldException;
}
