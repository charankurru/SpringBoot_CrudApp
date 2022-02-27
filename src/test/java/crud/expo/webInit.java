package crud.expo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class webInit {
    public static  void main(String[] args)
    {
        SpringApplication.run(webInit.class,args);
    }

    @RequestMapping("/hello")
    public String welcome()
    {
        return "Welcome User !";
    }
}
