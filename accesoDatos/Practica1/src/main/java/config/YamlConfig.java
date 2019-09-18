/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author dam2
 */
public class YamlConfig {

    private static YamlConfig config;

    private YamlConfig() {

    }
    
    private String clave;

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
    private List<String> claves;

    public List<String> getClaves() {
        return claves;
    }

    public void setClaves(List<String> claves) {
        this.claves = claves;
    }
    
    

    public static YamlConfig getInstance() {

        if (config == null) {
            try {
                Yaml yaml = new Yaml();
                config = (YamlConfig) yaml.loadAs(new FileInputStream("config/configuracionUsuario.yml"),
                        YamlConfig.class);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(YamlConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return config;
    }

}
