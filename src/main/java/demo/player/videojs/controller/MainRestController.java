package demo.player.videojs.controller;

import demo.player.videojs.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MainRestController {

  private final MainService mainService;

  @PostMapping("/api/completions")
  public void ended() {
    System.out.println("Play Count + 1 !!!");
  }

  @PostMapping("/api/playCountUp")
  public ResponseEntity countUp() {
    mainService.countUp(9999L);
    return new ResponseEntity(HttpStatus.OK);
  }
}
