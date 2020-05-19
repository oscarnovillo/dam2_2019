package servicios;

import dao.DaoUsuarios;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import rest.dto.converters.UserConverter;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(Arquillian.class)
class ServiciosUsuariosTest {

  @Deployment
  public static JavaArchive createDeployment() {
    return ShrinkWrap.create(JavaArchive.class)
        .addClass(ServiciosUsuarios.class)
        .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
  }


  @Inject
  ServiciosUsuarios service;

  @Test
  void getUsers() {
    assertEquals(2,service.getUsers().size());

  }


}