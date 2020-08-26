package com.company;

import java.util.Scanner;

public class CommandPanel {

    public Transport transport;

    public CommandPanel(Transport transport) {
        this.transport = transport;
    }

    public void init(){

        System.out.println("Введите M, TR, TL или exit");

        Scanner scanner = new Scanner(System.in);

        while (true){
            String currentString = scanner.nextLine();

            if(currentString.equalsIgnoreCase("exit")){
                break;
            }

            Command currentCommand = convertStringToCommand(currentString);

            try {
                executeCommand(currentCommand);
            } catch (EndOfFieldException e) {
                e.printStackTrace();
            }

        }
    }

    private Command convertStringToCommand(String commandName){
        if (commandName.equalsIgnoreCase("M")){
            return new MoveForwardCommand(this);
        }

        if (commandName.equalsIgnoreCase("TR")){
            return new TurnDirectionCommand(this, true);
        }

        if (commandName.equalsIgnoreCase("TL")){
            return new TurnDirectionCommand(this, false);
        }

        return new MoveForwardCommand(this);
    }

    public void executeCommand(Command command) throws EndOfFieldException {
        if(command.execute()){
            System.out.println("Success execute command " + command.toString());
        } else {
            throw new EndOfFieldException();
        }
    }
}
