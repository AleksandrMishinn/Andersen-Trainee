package com.company;

/**
 * Необходимо выполнить рефакторинг существующего кода - исправить все места, которые вам покажутся некрасивыми или не
 * правильными. Можно изменять этот класс и/или добавлять новые. Результатом работы должен быть код, который будет прост
 * и понятен, без логических ошибок. Так же необходимо предусмотреть возможность дальнейшего расширения функционала -
 * могут быть добавлены как новые команды для трактора (новые способы движения, вращения), так и новые "фигуры", которые
 * могут двигатся совершенно в другой системе координат.
 */
public class Tractor extends Transport {

    public Tractor(int[] position, Field field, Orientation orientation) {
        super(position, field, orientation);
    }

    public Tractor() {
        this(new int[]{0, 0}, new Field(new int[]{5, 5}), Orientation.NORTH);
    }

    @Override
    void moveForwards() {
        position = switch (orientation) {
            case NORTH -> new int[]{position[0], position[1] + 1};
            case EAST -> new int[]{position[0] + 1, position[1]};
            case SOUTH -> new int[]{position[0], position[1] - 1};
            case WEST -> new int[]{position[0] - 1, position[1]};
        };
    }
}
