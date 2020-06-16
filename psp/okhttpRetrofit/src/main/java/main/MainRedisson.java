package main;

import com.datoshttp.Mensaje;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class MainRedisson {

  public static void main(String[] args) {
    Config config = new Config();
    config.useSingleServer().setAddress("redis://127.0.0.1:6379");
    RedissonClient rdson = Redisson.create(config);

    Mensaje m = new Mensaje();
    m.setFrom("from");
    m.setMensaje("mensaje");
    m.setRoom("room");
    RBucket<Mensaje> mensaje  = rdson.getBucket("probando");

    mensaje.set(m);

rdson.shutdown();

    rdson = Redisson.create(config);
    RBucket<Mensaje> mensaje2  = rdson.getBucket("probando");
    m = mensaje2.get();
    System.out.println(m.getFrom());
    rdson.shutdown();

  }
}
