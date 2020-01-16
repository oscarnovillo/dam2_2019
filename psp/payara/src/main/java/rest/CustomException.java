package rest;

public class CustomException extends RuntimeException {

  public CustomException(String message) {
    super(message);
  }

  private int codigo;

}
