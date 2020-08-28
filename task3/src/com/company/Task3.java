package com.company;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Task3 {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger(Task3.class.getName());
        Scanner scanner = new Scanner(System.in);

        logger.info("Введите количество денег:");
        int money = scanner.nextInt();

        if (money < 1){
            logger.info("Нужно больше золота.");
            return;
        }

        logger.info("Введите стоимость конфеты:");
        int price = scanner.nextInt();

        if (price < 1){
            logger.info("Низкая стоимость позволяет вам съесть бесконечное количество конфет.");
            return;
        }

        logger.info("Введите количество фантиков для получения бонусной конфеты:");
        int bonus = scanner.nextInt();

        if (bonus < 2){
            logger.info("Программа лояльности позволяет вам съесть бесконечное количество конфет.");
            return;
        }

        int candiesQuantity = getMaximumCandies(money, price, bonus);
        logger.log(Level.INFO, "Можно съесть " + candiesQuantity + " конфет.");

    }

    public static int getMaximumCandies(int money, int price, int bonus) {

        int candiesForTheMoney = getCandiesForTheMoney(money, price);
//        int candiesForWrappers = getCandiesForBonus(candiesForTheMoney, bonus, 0);
        int candiesForWrappers = getCandiesForBonusWithoutRecursion(candiesForTheMoney, bonus, 0);

        return candiesForTheMoney + candiesForWrappers;
    }

    private static int getCandiesForTheMoney(int money, int price) {
        return money / price;
    }

    private static int getCandiesForBonus(int wrappers, int bonus, int totalBonusCandies) {

        int bonusCandies = wrappers / bonus;
        totalBonusCandies += bonusCandies;
        wrappers = wrappers - bonusCandies * bonus + bonusCandies;

        if (wrappers < bonus) {
            return totalBonusCandies;
        } else {
            return getCandiesForBonus(wrappers, bonus, totalBonusCandies);
        }
    }

    private static int getCandiesForBonusWithoutRecursion(int wrappers, int bonus, int totalBonusCandies){

        while(wrappers > bonus){
            int bonusCandies = wrappers / bonus;
            totalBonusCandies += bonusCandies;
            wrappers = wrappers - bonusCandies * bonus + bonusCandies;
        }
        return totalBonusCandies;
    }

}
