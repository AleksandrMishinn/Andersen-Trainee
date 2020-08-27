package com.company.commands.factories;

import com.company.commands.commands.MeditationCommand;

public class NatureCommandFactory extends CommandFactory {
    {
        COMMANDS.put("M", new MeditationCommand());
    }
}
