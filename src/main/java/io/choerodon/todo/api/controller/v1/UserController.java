package io.choerodon.todo.api.controller.v1;

import io.choerodon.asgard.saga.producer.StartSagaBuilder;
import io.choerodon.asgard.saga.producer.TransactionalProducer;
import io.choerodon.base.annotation.Permission;
import io.choerodon.base.enums.ResourceType;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.todo.app.service.UserService;
import io.choerodon.todo.infra.dto.UserDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/users")
public class UserController {
    private UserService userService;
    private TransactionalProducer producer;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @Permission(type = ResourceType.SITE, permissionLogin = true)
//    @Permission(type = ResourceType.SITE, permissionPublic = true)
    @ApiOperation(value = "创建todo用户")
//    @Transactional
    private ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO, Object sagaPayload, Long orgId) {

        producer.applyAndReturn(
                StartSagaBuilder
                        .newBuilder()
                        .withLevel(ResourceLevel.ORGANIZATION)
                        .withRefType("organization")
                        .withSagaCode("asgard-create-user"),
                builder -> {
                    userService.createOne(userDTO);
                    builder
                            .withPayloadAndSerialize(sagaPayload)
                            .withRefId(String.valueOf(orgId))
                            .withSourceId(orgId);
                    return sagaPayload;
                });
        return new ResponseEntity<>(userService.createOne(userDTO), HttpStatus.OK);
    }
}