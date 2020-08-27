package com.company.commands.commands;

import com.company.commands.exceptions.EndOfFieldException;

public class MeditationCommand extends Command {
    @Override
    public boolean execute() throws EndOfFieldException {
        return true;
    }

    @Override
    public String toString() {
        return "медитирует...";
    }
}
