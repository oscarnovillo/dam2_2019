package rest.dto.converters;

import dao.modelo.Usuario;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import rest.dto.UserDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


@RequestScoped
public class UserConverter {

  @Inject
    private ModelMapper modelMapper;

  public UserDTO converterUserUserDTO(Usuario user) {
//    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(user,UserDTO.class);
  }
}
