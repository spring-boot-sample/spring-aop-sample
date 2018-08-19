package spring.sample.aop;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {



    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "ok";
    }

    @RequestMapping(value = "/test/{id}",method = RequestMethod.GET)
    public String testById(@PathVariable String id){
        return id;
    }

}
