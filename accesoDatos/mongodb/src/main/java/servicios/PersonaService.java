package servicios;

import lombok.RequiredArgsConstructor;
import modelo.Persona;
import modelo.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service @RequiredArgsConstructor
public class PersonaService {

  private final PersonaRepository rp;

  public List<Persona> findAll()
  {
    return rp.findAll();
  }

}
