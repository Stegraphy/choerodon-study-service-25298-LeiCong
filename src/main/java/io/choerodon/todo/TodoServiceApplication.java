package io.choerodon.todo;

import io.choerodon.base.annotation.Permission;
import io.choerodon.resource.annoation.EnableChoerodonResourceServer;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
// 是否允许注册到注册中心，暂时注释掉
@EnableEurekaClient
// 是否开启猪齿鱼资源服务器
@EnableChoerodonResourceServer
@EnableFeignClients
@RestController
public class TodoServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TodoServiceApplication.class, args);
    }

  /*  @GetMapping
    @Permission(permissionPublic = true)
    @ApiOperation(value = "demo")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<String>("hello world.", HttpStatus.OK);
    }*/
}
