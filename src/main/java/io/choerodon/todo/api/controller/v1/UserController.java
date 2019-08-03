package io.choerodon.todo.api.controller.v1;

import io.choerodon.base.annotation.Permission;
import io.choerodon.base.enums.ResourceType;
import io.choerodon.todo.app.service.UserService;
import io.choerodon.todo.infra.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping(value = "/v1/users")
public class UserController {

    private UserService userService;

    @Autowired
    QueryUser queryUser;

    public UserController(UserService userService) {
        this.userService = userService;
    }



 /*   @PostMapping(value = "/organizations/{organization_id}/users/{user_id}")
//    @Permission(type = ResourceType.SITE, permissionLogin = false)
//    @Permission(type = ResourceType.SITE, permissionPublic = true)
    @ApiOperation(value = "插入查询的User用户")
//    @Transactional
    private ResponseEntity<UserDTO> create(@RequestBody ResponseEntity<UserDTO> userDTO, @PathVariable(name = "organization_id") Long organizationId,
                                           @PathVariable(name = "user_id") Long user_id) {


        userDTO = queryUser.query(organizationId,user_id);
        System.out.println("Coming>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(userDTO);
        userService.createOne(userDTO);
            return userDTO;
//        return new ResponseEntity<UserDTO>((MultiValueMap<String, String>) userService.createOne(userDTO), HttpStatus.OK);
    }
*/


    @GetMapping(value = "/userDto/{id}")
    public UserDTO query(@PathVariable(name = "id") Long id){
        UserDTO userDTO = userService.query(id);
        System.out.println(userDTO);
        return userDTO;
    }

    @PostMapping(value = "/test/organization_id}/users/{user_id}")
    @Permission(type = ResourceType.SITE, permissionLogin = true)
    public ResponseEntity<UserDTO> insert(ResponseEntity<UserDTO> userDTO, @PathVariable(name = "organization_id") Long organizationId,
                                          @PathVariable(name = "user_id") Long user_id){
        userDTO = queryUser.query(organizationId,user_id);
        System.out.println("Coming>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(userDTO);
        userService.insert(userDTO);
        return userDTO;
    }
}