package modelo;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Builder
@RequiredArgsConstructor
@ToString
public class ApiError {

private final String message;
}
