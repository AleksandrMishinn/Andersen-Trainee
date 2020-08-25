package com.company;

public class Main {

    /**
     * Метод добавлен для демонстрации работы приложения.
     */
    public static void main(String[] args) {

        Transport tractor = new Tractor();
        TransportCommandPanel TCP = new TransportCommandPanel();

        for (int i = 0; i < 10; i++) {
            if (!Movable.isEndOfFieldAhead(tractor)) {
                TCP.executeCommand(tractor, Command.F);
                System.out.println("Трактор переместился на координаты: " + tractor.position[0] + " : " + tractor.position[1]);
            } else {
                TCP.executeCommand(tractor, Command.T);
                System.out.println("Трактор развернулся на " + tractor.orientation.toString());
            }
        }
    }
}
