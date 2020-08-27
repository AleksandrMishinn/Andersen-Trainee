package com.company;

public class NatureCommandFactory extends CommandFactory {
    {
        COMMANDS.put("M", new MeditationCommand());
    }
}
