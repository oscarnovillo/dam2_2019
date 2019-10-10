package config;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class Configuration {

  private static Configuration config;

  private Configuration() {

  }

  public static Configuration getInstance() {

    return config;
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



    private String user;
    private String pass;

    private List<String> casas;
    private Map<String, String> recetas;

    public List<String> getCasas() {
      return casas;
    }

    public void setCasas(List<String> casas) {
      this.casas = casas;
    }

    public Map<String, String> getRecetas() {
      return recetas;
    }

    public void setRecetas(Map<String, String> recetas) {
      this.recetas = recetas;
    }

    public String getPass() {
      return pass;
    }

    public void setPass(String pass) {
      this.pass = pass;
    }

    public String getUser() {
      return user;
    }

    public void setUser(String user) {
      this.user = user;
    }

}
