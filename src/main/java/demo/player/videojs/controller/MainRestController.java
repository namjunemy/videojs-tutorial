package demo.player.videojs.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {
  @PostMapping("/api/completions")
  public void ended() {
    System.out.println("Play Count + 1 !!!");
  }
}
