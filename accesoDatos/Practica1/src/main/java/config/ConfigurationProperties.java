/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author roble
 */
public class ConfigurationProperties {

    private static ConfigurationProperties config;

    private ConfigurationProperties() {
    }

    private Properties p;

    public Properties getP() {
        return p;
    }
    
    private String clave;

    public String getClave() {
        return clave;
    }
    
    private List claves;

    public List getClaves() {
        return claves;
    }
    
    
    
    
    public static ConfigurationProperties getInstance() {
        if (config == null) {
            try {
                config = new ConfigurationProperties();
                config.p = new Properties();
                config.p.load(new FileInputStream("config/paths.properties"));
                config.clave = config.p.getProperty("clave");
                config.claves = Arrays.asList(config.p.getProperty("claves").split(","));
            } catch (Exception ex) {
                Logger.getLogger(ConfigurationProperties.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return config;
    }

}
