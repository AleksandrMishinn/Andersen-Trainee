package com.company;

public class TurnRightCommand extends Command {

    @Override
    public boolean execute() {
        this.getFigure().setOrientation(this.getFigure().getOrientation().next());
        return true;
    }

    @Override
    public String toString() {
        return " развернулся на " + this.getFigure().getOrientation().getTitle();
    }
}
