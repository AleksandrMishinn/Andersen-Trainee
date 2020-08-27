package com.company;

public enum Orientation {

    NORTH("север", 0, 1) {
        @Override
        Orientation next() {
            return EAST;
        }

        @Override
        Orientation previous() {
            return WEST;
        }
    },
    EAST("восток", 1, 0) {
        @Override
        Orientation next() {
            return SOUTH;
        }

        @Override
        Orientation previous() {
            return NORTH;
        }
    },
    SOUTH("юг", 0, -1) {
        @Override
        Orientation next() {
            return WEST;
        }

        @Override
        Orientation previous() {
            return EAST;
        }
    },
    WEST("запад", -1, 0) {
        @Override
        Orientation next() {
            return NORTH;
        }

        @Override
        Orientation previous() {
            return SOUTH;
        }
    };

    private String title;
    private int XValue;
    private int YValue;

    Orientation(String title, int XValue, int YValue) {
        this.title = title;
        this.XValue = XValue;
        this.YValue = YValue;
    }

    public String getTitle() {
        return title;
    }

    public int getXValue() {
        return XValue;
    }

    public int getYValue() {
        return YValue;
    }

    abstract Orientation next();

    abstract Orientation previous();

    @Override
    public String toString() {
        return title;
    }
}
