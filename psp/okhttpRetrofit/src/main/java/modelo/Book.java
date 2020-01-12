package modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Book {
  @NotBlank
  private String name;

//  @Pattern(regexp = "^[\\p{Alnum}]{1,32}$")
  @Min( value=34)
  private int numeroPaginas;

}
