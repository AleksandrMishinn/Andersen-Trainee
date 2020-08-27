package com.company.commands.commands;

public class TurnRightCommand extends Command {

    @Override
    public boolean execute() {
        super.getFigure().setOrientation(super.getFigure().getOrientation().next());
        return true;
    }

    @Override
    public String toString() {
        return " развернулся на " + super.getFigure().getOrientation().getTitle();
    }
}
