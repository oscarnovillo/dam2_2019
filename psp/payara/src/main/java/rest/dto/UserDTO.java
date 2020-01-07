package rest.dto;

import lombok.*;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class UserDTO {


  private String login;

  @Builder.Default
  private String url = "Nada";
}
