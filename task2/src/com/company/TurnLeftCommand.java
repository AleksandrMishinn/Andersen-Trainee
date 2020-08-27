package com.company;

public class TurnLeftCommand extends Command {

    @Override
    public boolean execute() {
        this.getFigure().setOrientation(this.getFigure().getOrientation().previous());
        return true;
    }

    @Override
    public String toString() {
        return " развернулся на " + this.getFigure().getOrientation().getTitle();
    }
}
