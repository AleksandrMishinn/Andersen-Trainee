package com.company;

public class Main {

    /**
     * Метод добавлен для демонстрации работы приложения.
     */
    public static void main(String[] args) {

//        Figure tractor = new Tractor();
//        CommandPanel panel = new CommandPanel(tractor);
//        panel.init();

        Figure stone = new Stone();
        CommandPanel panel = new CommandPanel(stone);
        panel.init();

    }
}
