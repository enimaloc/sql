package fr.enimaloc.sql.core;

import fr.enimaloc.sql.core.objects.TableObj;
import fr.enimaloc.sql.core.request.Request;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Database {

    static Database getDatabaseNoError(Class<? extends Database> clazz) {
        Logger logger = LoggerFactory.getLogger(Database.class);
        try {
            return getDatabase(clazz);
        } catch (InstantiationException e) {
            logger.error(String.format("%s cannot be instantiated", clazz.getName()), e);
        } catch (IllegalAccessException e) {
            logger.error(String.format("No access to constructor of %s", clazz.getName()), e);
        } catch (InvocationTargetException e) {
            logger.error(String.format("An execution was thrown when invoking constructor of %s", clazz.getName()), e);
        } catch (NoSuchMethodException e) {
            logger.error(String.format("No constructor with 0 parameters found on %s", clazz.getName()), e);
        }
        return null;
    }

    static Database getDatabase(Class<? extends Database> clazz)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return clazz.getConstructor().newInstance();
    }

    boolean connect();

    Request<List<TableObj>> get(String tableName);

    <T> Request<List<T>> get(T table);

}
