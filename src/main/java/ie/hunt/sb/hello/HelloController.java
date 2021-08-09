package ie.hunt.sb.hello;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }


    @GetMapping("/{{name}}")
    public String greet(String name) {
        //TODO: broken .. how do we map path params
        //TODO: broken .. no test cases .. how do we write a test-case??
        return "Greetings from Spring Boot:" + name;
    }

}