package com.company;

public class TransportCommandPanel {
    public void executeCommand(Transport transport, Command command) {
        switch (command) {
            case F -> Movable.moveForwards(transport);
            case T -> Rotary.turnDirection(transport, true);
            default -> throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
