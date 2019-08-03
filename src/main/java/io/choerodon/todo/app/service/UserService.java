package io.choerodon.todo.app.service;

import io.choerodon.todo.infra.dto.UserDTO;

public interface UserService {
    UserDTO createOne(UserDTO userDTO);
}