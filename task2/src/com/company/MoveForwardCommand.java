package com.company;

public class MoveForwardCommand extends Command{

    public MoveForwardCommand(Transport transport) {
        super(transport);
    }

    public MoveForwardCommand() {
    }

    @Override
    public boolean execute() {

        int[] axisValue = transport.orientation.getAxisValue();
        transport.position = new int[] {transport.position[0] + axisValue[0], transport.position[1] + axisValue[1]};

        int[] fieldsSize = transport.field.getSize();
        int NumberOfDirections = fieldsSize.length;

        for (int i = 0; i < NumberOfDirections; i++) {
            if (fieldsSize[i] < transport.position[i] || transport.position[i] < 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Транспорт переместился на координаты " + transport.position[0] + " : " + transport.position[1];
    }
}
