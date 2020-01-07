package rest.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class TestDto {

  @NotEmpty
  private String id;

  public TestDto(String id) {
    this.id = id;
  }
}
