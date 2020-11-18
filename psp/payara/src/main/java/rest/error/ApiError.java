package rest.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Getter
@Log4j2
public class ApiError {

  private final String message;


}
