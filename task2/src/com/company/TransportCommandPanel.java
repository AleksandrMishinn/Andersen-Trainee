package com.company;

public class TransportCommandPanel {
    public void executeCommand(Transport transport, Command command) {
        switch (command) {
            case F -> transport.moveForwards();
            case T -> transport.turnDirection(true);
            default -> throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
