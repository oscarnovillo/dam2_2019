package rest.dto.converters;

import dao.modelo.Usuario;
import org.modelmapper.ModelMapper;
import rest.dto.UserDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;


@RequestScoped
public class UserConverter {

    @Inject
    private ModelMapper modelMapper;

    public UserDTO converterUserUserDTO(Usuario user) {
//    ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, UserDTO.class);
    }
}
