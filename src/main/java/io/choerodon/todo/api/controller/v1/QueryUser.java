package io.choerodon.todo.api.controller.v1;

import io.choerodon.todo.infra.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("iam-service")
public interface QueryUser {
    @GetMapping(value = "/iam/v1/organizations/{organization_id}/users/{user_id}")
    public ResponseEntity<UserDTO> query(@PathVariable(name = "organization_id") Long organizationId,
                                         @PathVariable Long user_id);
}
