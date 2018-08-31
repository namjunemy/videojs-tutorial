package demo.player.videojs.controller;

import demo.player.videojs.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class MainController {

  private final MainService mainService;

  @GetMapping("/")
  public String home(Model model) {
    return "index";
  }
}
