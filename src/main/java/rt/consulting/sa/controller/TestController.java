package rt.consulting.sa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //permet de dire que ce sera un controller qui sera exposé pour des api rest
@RequestMapping(path = "test") // les url à traiter dans ce controler
public class TestController {

    @GetMapping(path="string") //url/string
    public String getString(){
        return "Hello me";
    }
    @GetMapping //url/string
    public List<String> getList(){
        return List.of("Hello me", "romeo");
    }
}
