package com.company;

public class Main {

    /**
     * Метод добавлен для демонстрации работы приложения.
     */
    public static void main(String[] args) {

        Transport tractor = new Tractor();
        CommandPanel panel = new CommandPanel(tractor);
        panel.init();

    }
}
