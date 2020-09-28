package utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryUtil {
    public final static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("ru.andersentrainee");

    public static EntityManagerFactory getFactory(){
        return ENTITY_MANAGER_FACTORY;
    }
}
