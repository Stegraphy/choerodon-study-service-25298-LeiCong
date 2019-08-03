package io.choerodon.todo.api.controller.v1;

import io.choerodon.base.annotation.Permission;
import io.choerodon.base.enums.ResourceType;
import io.choerodon.todo.infra.dto.UserDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryUserController {
   /* @Autowired
    QueryUser queryUser;
    @GetMapping(value = "/user/{organization_id}/{id}")
    @Permission(type = ResourceType.SITE, permissionLogin = true)
//    @Permission(type = ResourceType.SITE, permissionPublic = true)
    @ApiOperation(value = "根据id查询用户")
    public ResponseEntity<UserDTO> query(@PathVariable(name = "organization_id") Long organizationId,
                                         @PathVariable Long id) {
        return queryUser.query(organizationId,id);
    }*/
}
