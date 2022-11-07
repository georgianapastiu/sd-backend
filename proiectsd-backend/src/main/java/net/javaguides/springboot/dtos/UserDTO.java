package net.javaguides.springboot.dtos;
import net.javaguides.springboot.model.Rol;
import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;
import java.util.UUID;

public class UserDTO extends RepresentationModel<UserDTO> {

    private UUID id;
    private String name;
    private String username;
    private Rol rol;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO personDTO = (UserDTO) o;
        return name == personDTO.name &&
                Objects.equals(name, personDTO.name);
    }

}
