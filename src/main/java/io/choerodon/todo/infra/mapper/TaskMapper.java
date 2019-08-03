package io.choerodon.todo.infra.mapper;

import io.choerodon.mybatis.common.Mapper;
import io.choerodon.todo.infra.dto.TaskDTO;
import org.apache.ibatis.annotations.Param;


public interface TaskMapper extends Mapper<TaskDTO> {
    TaskDTO queryByTaskNumber(@Param("taskNumber") String taskNumber);
}
