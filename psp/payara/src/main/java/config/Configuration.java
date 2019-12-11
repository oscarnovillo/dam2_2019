/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oscar
 */
public class Configuration {

    private static Configuration config;

    private Configuration() {

    }

    public static Configuration getInstance(InputStream file) {
        if (config == null) {
            Yaml yaml = new Yaml();
            config = (Configuration) yaml.loadAs(
                file,
                Configuration.class);

        }
        return config;
    }

    public static Configuration getInstance() {

        return config;
    }
    private String urlDB;
    private String driverDB;
    private String userDB;
    private String passDB;


    public String getUrlDB() {
      
        return urlDB;
    }

    public void setUrlDB(String urlDB) {
        this.urlDB = urlDB;
    }

    public String getDriverDB() {
        return driverDB;
    }

    public void setDriverDB(String driverDB) {
        this.driverDB = driverDB;
    }

    public String getUserDB() {
        return userDB;
    }

    public void setUserDB(String userDB) {
        this.userDB = userDB;
    }

    public String getPassDB() {
        return passDB;
    }

    public void setPassDB(String passDB) {
        this.passDB = passDB;
    }

}
