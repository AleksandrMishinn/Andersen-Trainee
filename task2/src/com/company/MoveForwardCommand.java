package com.company;

public class MoveForwardCommand extends Command{

    public MoveForwardCommand(Transport transport) {
        super(transport);
    }

    public MoveForwardCommand() {

    }

    @Override
    public boolean execute() {

        int[] currentPosition = transport.position;

        transport.position = switch (transport.orientation) {
            case NORTH -> new int[]{currentPosition[0], currentPosition[1] + 1};
            case EAST -> new int[]{currentPosition[0] + 1, currentPosition[1]};
            case SOUTH -> new int[]{currentPosition[0], currentPosition[1] - 1};
            case WEST -> new int[]{currentPosition[0] - 1, currentPosition[1]};
        };

        int[] fieldsSize = transport.field.getSize();
        int NumberOfDirections = fieldsSize.length;

        for (int i = 0; i < NumberOfDirections; i++) {
            if (fieldsSize[i] < transport.position[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "MoveForwardCommand{}";
    }
}
