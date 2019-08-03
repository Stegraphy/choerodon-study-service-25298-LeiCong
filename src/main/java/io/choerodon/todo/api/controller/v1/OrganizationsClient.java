package io.choerodon.todo.api.controller.v1;

import io.choerodon.todo.infra.dto.OrganizationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("iam-service")
public interface OrganizationsClient {
    @GetMapping(value = "/v1/organizations/{organization_id}")
    ResponseEntity<OrganizationDTO> getOrgnization(@PathVariable(name = "organization_id") Long id);
//    public ResponseEntity<OrganizationDTO> query(@PathVariable(name = "organization_id") Long id) {
//        return new ResponseEntity<>(organizationService.queryOrganizationById(id), HttpStatus.OK);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
