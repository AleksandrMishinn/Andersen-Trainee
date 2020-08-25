package com.company;

import java.util.Arrays;

public interface Movable {

    static void moveForwards(Transport transport) {

        int[] currentPosition = transport.position;

        transport.position = switch (transport.orientation) {
            case NORTH -> new int[]{currentPosition[0], currentPosition[1] + 1};
            case EAST -> new int[]{currentPosition[0] + 1, currentPosition[1]};
            case SOUTH -> new int[]{currentPosition[0], currentPosition[1] - 1};
            case WEST -> new int[]{currentPosition[0] - 1, currentPosition[1]};
        };

    }

    static boolean isEndOfFieldAhead(Transport transport) {

        int[] oldPosition = Arrays.copyOf(transport.position, transport.position.length);
        boolean result = false;

        moveForwards(transport);

        int[] fieldsSize = transport.field.getSize();
        int NumberOfDirections = fieldsSize.length;

        for (int i = 0; i < NumberOfDirections; i++) {
            if (fieldsSize[i] < transport.position[i]) {
                result = true;
                break;
            }
        }
        transport.position = oldPosition;
        return result;
    }
}
