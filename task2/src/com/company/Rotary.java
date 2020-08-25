package com.company;

public interface Rotary {
    static void turnDirection(Transport transport, boolean clockwise) {
        transport.orientation = clockwise ? Orientation.next(transport.orientation) : Orientation.previous(transport.orientation);
    }
}
