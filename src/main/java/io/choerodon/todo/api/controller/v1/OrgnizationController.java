package io.choerodon.todo.api.controller.v1;

import io.choerodon.base.annotation.Permission;
import io.choerodon.base.enums.ResourceType;
import io.choerodon.todo.infra.dto.OrganizationDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrgnizationController {
    @Autowired
    OrganizationsClient organizationsClient;
    @GetMapping(value = "/organization/{organization_id}")
    @Permission(type = ResourceType.SITE, permissionLogin = true)
//    @Permission(type = ResourceType.SITE, permissionPublic = true)
    @ApiOperation(value = "查询组织结构")
        public ResponseEntity<OrganizationDTO> query(@PathVariable(name = "organization_id") Long id) {
//        return new ResponseEntity<>(organizationService.queryOrganizationById(id), HttpStatus.OK);
//        return new ResponseEntity<>(organizationsClient.getOrgnization(),HttpStatus.OK);
        if(organizationsClient.getOrgnization(id) == null){
            System.out.println("查询结果为空！");
        }
//        List<OrganizationDTO> organizationDTOS = (List<OrganizationDTO>) organizationsClient.getOrgnization(id);
//        return organizationDTOS;
        return organizationsClient.getOrgnization(id);
    }
}
