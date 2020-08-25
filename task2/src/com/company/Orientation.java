package com.company;

public enum Orientation {

    NORTH ("север"), EAST ("восток"), SOUTH ("юг"), WEST("запад");

    private String title;

    Orientation(String title) {
        this.title = title;
    }

    public static Orientation next(Orientation currentOrientation) {
        return switch (currentOrientation) {
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
        };
    }

    public static Orientation previous(Orientation currentOrientation) {
        return switch (currentOrientation) {
            case NORTH -> WEST;
            case EAST -> NORTH;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
        };
    }

    @Override
    public String toString() {
        return title;
    }
}
