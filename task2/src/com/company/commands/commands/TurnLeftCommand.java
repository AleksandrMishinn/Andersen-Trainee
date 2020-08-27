package com.company.commands.commands;

public class TurnLeftCommand extends Command {

    @Override
    public boolean execute() {
        super.getFigure().setOrientation(super.getFigure().getOrientation().previous());
        return true;
    }

    @Override
    public String toString() {
        return " развернулся на " + super.getFigure().getOrientation().getTitle();
    }
}
