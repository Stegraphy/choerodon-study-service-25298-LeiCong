package io.choerodon.todo.app.service.impl;

import io.choerodon.asgard.saga.annotation.Saga;
import io.choerodon.core.exception.CommonException;
import io.choerodon.todo.app.service.UserService;
import io.choerodon.todo.infra.dto.UserDTO;
import io.choerodon.todo.infra.mapper.UserMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    @Saga(code = "asgard-create-user", description = "创建用户", inputSchemaClass = UserDTO.class)
    public UserDTO createOne(UserDTO userDTO) {
        if (userMapper.insert(userDTO) != 1) {
            throw new CommonException("error.user.insert");
        }
        return userDTO;
    }

    @Override
    public ResponseEntity<UserDTO> createOne(ResponseEntity<UserDTO> userDTO) {
        return userDTO;
    }

    @Override
    public UserDTO query(Long id) {
        return userMapper.queryById(id);
    }

//    @Override
//    public int insert(ResponseEntity<UserDTO> userDTO) {
////        return userMapper.insert(userDTO);
//        return null;
//    }
}