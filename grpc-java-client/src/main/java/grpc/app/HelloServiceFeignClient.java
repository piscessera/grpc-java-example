package grpc.app;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "helloServiceFeignClient", url = "${hello.service.rest.endpoint}")
public interface HelloServiceFeignClient {
    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String hello(@RequestParam("f") String firstName, @RequestParam("l") String lastName);
}
