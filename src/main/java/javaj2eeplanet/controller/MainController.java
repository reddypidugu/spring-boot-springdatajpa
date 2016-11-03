package javaj2eeplanet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

  @RequestMapping("/")
  @ResponseBody
  public String index() {
    return "Made by " +
        "<a href='http://javaj2eeplanet.blogspot.com'>JavaJ2eePlanet</a> :)";
  }

}
