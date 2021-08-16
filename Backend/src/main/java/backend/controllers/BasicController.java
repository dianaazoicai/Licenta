package backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import backend.services.HelloService;

@RestController
public class BasicController {
    @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
    @ResponseBody
    public String hello()
    {
        HelloService hello=new HelloService();
        return hello.getHello();
    }
}
