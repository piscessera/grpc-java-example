package grpc;

import grpc.app.HelloServiceClient;
import grpc.app.HelloServiceFeignClient;
import org.example.grpc.server.HelloResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private HelloServiceClient helloServiceClient;

    @Autowired
    private HelloServiceFeignClient helloServiceFeignClient;

    @GetMapping("/hello")
    public String hello(@RequestParam("f") String firstName, @RequestParam("l") String lastName) {
        HelloResponse response = helloServiceClient.hello(firstName, lastName);
        if (response == null) {
            return "NullPointerException";
        } else {
            return response.toString();
        }
    }

    @GetMapping("/hello2")
    public String hello2(@RequestParam("f") String firstName, @RequestParam("l") String lastName) {
        return helloServiceFeignClient.hello(firstName, lastName);
    }
}
