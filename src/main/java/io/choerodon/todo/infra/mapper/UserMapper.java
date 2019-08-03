package io.choerodon.todo.infra.mapper;

import io.choerodon.mybatis.common.Mapper;
import io.choerodon.todo.infra.dto.UserDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserMapper extends Mapper<UserDTO> {
    public List<UserDTO> listUsersByIds(Long id);
    public UserDTO queryById(@PathVariable(name = "id")Long id);

}
