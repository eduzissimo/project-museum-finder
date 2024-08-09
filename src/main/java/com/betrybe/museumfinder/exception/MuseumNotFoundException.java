package com.betrybe.museumfinder.exception;

/**
 * Exception para quando um museu não é achado.
 */
public class MuseumNotFoundException extends RuntimeException {
  public MuseumNotFoundException(String message) {
    super(message);
  }

}
