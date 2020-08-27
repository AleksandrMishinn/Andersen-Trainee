package com.company;

public class MeditationCommand extends Command{
    @Override
    public boolean execute() throws EndOfFieldException {
        return true;
    }

    @Override
    public String toString() {
        return "медитирует...";
    }
}
