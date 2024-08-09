package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe controller para o Museu.
 */
@RestController
@RequestMapping("/museums")
public class MuseumController {
  private final MuseumServiceInterface museumService;

  @Autowired
  public MuseumController(MuseumServiceInterface museumService) {
    this.museumService = museumService;
  }

  @PostMapping
  public ResponseEntity<Museum> createMuseum(@RequestBody Museum museum) {
    Museum createdMuseum = museumService.createMuseum(museum);
    return new ResponseEntity<>(createdMuseum, HttpStatus.CREATED);
  }
  /**
   * Método para buscar o museu mais próximo.
   *
   * @param latitude     Latitude do ponto de referência.
   * @param longitude    Longitude do ponto de referência.
   * @param maxDistance  Distância máxima em km.
   * @return ResponseEntity'Museum' com o museu mais próximo.
   */

  @GetMapping("/closest")
  public ResponseEntity<Museum> getClosestMuseum(
      @RequestParam(name = "lat") double latitude,
      @RequestParam(name = "lng") double longitude,
      @RequestParam(name = "max_dist_km") double maxDistance) {
    Coordinate coordinate = new Coordinate(latitude, longitude);
    Museum closestMuseum = museumService.getClosestMuseum(coordinate, maxDistance);
    return new ResponseEntity<>(closestMuseum, HttpStatus.OK);
  }
}
