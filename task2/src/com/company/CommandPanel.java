package com.company;

import java.util.Scanner;

public class CommandPanel {

    public Transport transport;

    public CommandPanel(Transport transport) {
        this.transport = transport;
    }

    public void init(){

        System.out.println("Введите команду или exit");
        Scanner scanner = new Scanner(System.in);

        while (true){
            String currentString = scanner.nextLine();

            if(currentString.equalsIgnoreCase("exit")){
                break;
            }

            try {
                Command command = CommandFactory.getCommand(currentString);
                command.transport = transport;
                executeCommand(command);
            } catch (EndOfFieldException e) {
                e.printStackTrace();
            }
        }
    }

    public void executeCommand(Command command) throws EndOfFieldException {
        if(command.execute()){
            System.out.println("Success execute command " + command.toString());
        } else {
            throw new EndOfFieldException();
        }
    }
}
