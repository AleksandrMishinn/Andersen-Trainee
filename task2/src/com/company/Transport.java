package com.company;

import java.util.Arrays;

public class Transport {

    protected Orientation orientation;
    protected Field field;
    protected int[] position;

    public Transport() {
        this(new int[]{0}, new Field(new int[]{5}), Orientation.NORTH);
    }

    public Transport(int[] position, Field field, Orientation orientation) {
        this.position = position;
        this.field = field;
        this.orientation = orientation;
    }

    void moveForwards() {
        position[0]++;
    }

    void turnDirection(boolean clockwise) {
        orientation = clockwise ? Orientation.next(orientation) : Orientation.previous(orientation);
    }

    boolean isEndOfFieldAhead() {

        int[] oldPosition = Arrays.copyOf(position, position.length);
        boolean result = false;

        moveForwards();

        int[] fieldsSize = field.getSize();
        int NumberOfDirections = fieldsSize.length;

        for (int i = 0; i < NumberOfDirections; i++) {
            if (fieldsSize[i] < position[i]) {
                result = true;
                break;
            }
        }
        position = oldPosition;
        return result;
    }

}
