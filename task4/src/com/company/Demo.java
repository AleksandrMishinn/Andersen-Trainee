package com.company;

import com.company.proxy.CacheProxy;
import com.company.service.HardCalculationService;
import com.company.service.Service;
import java.util.logging.Logger;

/**
 * Некоторые методы могут выполняться очень долго, хочется иметь возможность кешировать результаты возврата.
 * Например, у нас есть интерфейс Service c методом doHardWork().
 * Повторный вызов этого метода с теми же параметрами должен возвращать рассчитанный результат из кэша.
 * <p>
 * Необходимо реализовать класс CacheProxy с методом cache(), который принимает ссылку на сервис и возвращает кеширующую
 * версию этого сервиса.
 * Результаты вызова метода кеш должен хранить в памяти.
 * Должна быть возможность настройки кеша с помощью аннотаций: кешировать определенные методы или все методы класса.
 * Логика по кешированию должна навешиваться с помощью DynamicProxy.
 * <p>
 * Дизайн аннотаций, классов реализаций на вкус.
 * Код должен быть читаем, классы не перегружены логикой, классы должны лежать в нужных пакетах.
 */
public class Demo {

    private final static Logger LOGGER = Logger.getLogger(Demo.class.getName());

    public static void main(String[] args) throws InterruptedException {
        Service service = new HardCalculationService();
        CacheProxy cacheProxy = new CacheProxy(service);
        Service serviceWithProxy = (Service) cacheProxy.init();

        int result = serviceWithProxy.doHardWork(2);
        LOGGER.info("Завершен первичный расчет для числа 2. Результат: " + result);

        result = serviceWithProxy.doHardWork(2);
        LOGGER.info("Завершен повторный расчет для числа 2. Результат: " + result);
    }
}
