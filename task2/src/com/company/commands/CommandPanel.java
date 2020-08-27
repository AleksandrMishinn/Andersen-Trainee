package com.company.commands;

import com.company.commands.commands.Command;
import com.company.commands.exceptions.CommandExecuteException;
import com.company.commands.exceptions.CommandNotFoundException;
import com.company.commands.factories.CommandFactory;
import com.company.entities.Figure;

import java.util.Scanner;

public class CommandPanel {

    public Figure figure;

    public CommandPanel(Figure figure) {
        this.figure = figure;
    }

    public void init() {

        System.out.println("Введите команду или exit");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String currentString = scanner.nextLine();

            if (currentString.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                CommandFactory factory = figure.getFactory();
                Command command = factory.getCommand(currentString);
                command.setFigure(figure);
                executeCommand(command);
            } catch (CommandNotFoundException | CommandExecuteException e) {
                e.printStackTrace();
            }
        }
    }

    public void executeCommand(Command command) throws CommandExecuteException {
        if (command.execute()) {
            System.out.println(figure.toString() + " " + command.toString());
        } else {
            throw new CommandExecuteException();
        }
    }
}
