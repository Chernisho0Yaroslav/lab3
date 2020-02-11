package PO74.Tokmakov.wdad.data.storage;

import PO74.Tokmakov.wdad.data.managers.PreferencesManager;
import PO74.Tokmakov.wdad.utils.PreferencesManagerConstant;
//import org.hsqldb.jdbc.*;

import javax.sql.DataSource;

public class DataSourceFactory {

   /* public static DataSource createDataSource() {
        PreferencesManager manager = PreferencesManager.INSTANCE;
        return createDataSource(manager.getProperty(PreferencesManagerConstants.CLASS_NAME),
                manager.getProperty(PreferencesManagerConstants.CLASS_NAME),
*//*                manager.getProperty(PreferencesManagerConstants.DRIVER_TYPE),
                Integer.parseInt(manager.getProperty(PreferencesManagerConstants.PORT)),*//*
                manager.getProperty(PreferencesManagerConstants.DB_NAME),
                manager.getProperty(PreferencesManagerConstants.USER),
                manager.getProperty(PreferencesManagerConstants.PASS));
    }

    public static DataSource createDataSource(String className, *//*String
            driverType,*//* String host,*//* int port,*//* String dbName, String user, String password) {

        JDBCDataSource source = new JDBCDataSource();
        source.setDatabase(host);
        source.setUser(user);
        source.setPassword(password);
        source.setDatabaseName(dbName);
        return source;
    }*/
}