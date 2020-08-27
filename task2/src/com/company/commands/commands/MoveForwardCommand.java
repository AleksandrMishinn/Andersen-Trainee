package com.company.commands.commands;

import com.company.entities.Figure;
import com.company.commands.exceptions.EndOfFieldException;

public class MoveForwardCommand extends Command {

    @Override
    public boolean execute() throws EndOfFieldException {

        Figure figure = super.getFigure();

        figure.getPosition().setX(figure.getPosition().getX() + figure.getOrientation().getXValue());
        figure.getPosition().setY(figure.getPosition().getY() + figure.getOrientation().getYValue());

        if (figure.getField().getX() < figure.getPosition().getX() ||
                figure.getField().getY() < figure.getPosition().getY() ||
                figure.getPosition().getX() < 0 ||
                figure.getPosition().getY() < 0) {
            throw new EndOfFieldException();
        }
        return true;
    }

    @Override
    public String toString() {
        return " переместился на координаты " +
                super.getFigure().getPosition().getX() + " : " + super.getFigure().getPosition().getY();
    }
}
