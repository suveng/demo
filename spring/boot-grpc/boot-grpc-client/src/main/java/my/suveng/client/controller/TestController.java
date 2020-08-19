package my.suveng.client.controller;

import my.suveng.client.api.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author suwenguang
 **/
@RestController
public class TestController {
    @Autowired
    private ApiService apiService;

    @GetMapping("/test/grpc")
    public String tet() {
        return apiService.grpc();
    }
}
