package com.company;

public class MoveForwardCommand extends Command {

    @Override
    public boolean execute() throws EndOfFieldException {

        Figure figure = this.getFigure();

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
                getFigure().getPosition().getX() + " : " + getFigure().getPosition().getY();
    }
}
