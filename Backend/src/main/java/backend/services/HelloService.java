package backend.services;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String getHello(){
        return "Hello!";
    }
}
