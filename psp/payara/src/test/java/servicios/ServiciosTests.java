package servicios;

import dao.DaoUsuarios;
import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import rest.dto.converters.UserConverter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;


@EnableWeld
public class ServiciosTests {


  @WeldSetup
  WeldInitiator weldInitiator =     WeldInitiator.from(WeldInitiator.createWeld().enableDiscovery()).activate(RequestScoped.class).build();


//  @WeldSetup
//  public WeldInitiator weld = WeldInitiator.from(ServiciosUsuarios.class, DaoUsuarios.class,UserConverter.class, ModelMapper.class)
//      .activate(RequestScoped.class).build();

  @Inject
  ServiciosUsuarios service;


  @Test
  void tesT()
  {
    assertEquals(2,service.getUsers().size());
  }
}
