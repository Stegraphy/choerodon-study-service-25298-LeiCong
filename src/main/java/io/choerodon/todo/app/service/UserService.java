package io.choerodon.todo.app.service;

import io.choerodon.todo.infra.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserService {
    UserDTO createOne(UserDTO userDTO);

    ResponseEntity<UserDTO> createOne(ResponseEntity<UserDTO> userDTO);
//    List<UserDTO> insert(UserDTO userDTO);

    UserDTO query(@PathVariable(name = "id")Long id);

//    int insert(ResponseEntity<UserDTO> userDTO);
}