package io.choerodon.todo.api.controller.v1;

import io.choerodon.base.annotation.Permission;
import io.choerodon.base.enums.ResourceType;
import io.choerodon.todo.infra.dto.UserDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QueryUserController {
    @Autowired
    QueryUser queryUser;
    @GetMapping(value = "organizations/{organization_id}/users/{user_id}")
    @Permission(type = ResourceType.SITE, permissionLogin = true)
//    @Permission(type = ResourceType.SITE, permissionPublic = true)
    @ApiOperation(value = "根据id查询用户")
    public ResponseEntity<UserDTO> query(@PathVariable(name = "organization_id") Long organizationId,
                                         @PathVariable Long user_id) {
        ResponseEntity<UserDTO> userDTO = queryUser.query(organizationId,user_id);

        System.out.println("Here？");
        System.out.println(userDTO);
        return queryUser.query(organizationId,user_id);
    }


}
