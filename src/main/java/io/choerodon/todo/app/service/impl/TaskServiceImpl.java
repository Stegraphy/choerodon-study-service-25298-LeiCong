package io.choerodon.todo.app.service.impl;

import io.choerodon.core.exception.CommonException;
import io.choerodon.todo.app.service.TaskService;
import io.choerodon.todo.infra.dto.TaskDTO;
import io.choerodon.todo.infra.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskMapper taskMapper;


    public TaskServiceImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskDTO createOne(TaskDTO taskDTO) {
        if (taskMapper.insert(taskDTO) != 1) {
            throw new CommonException("error.task.insert");
        }
        return taskDTO;
    }

    @Override
    public TaskDTO queryById(Long id) {
        return taskMapper.selectByPrimaryKey(id);
    }

    @Override
    public TaskDTO queryByTaskNumber(String taskNumber) {
        return taskMapper.queryByTaskNumber(taskNumber);
    }

    @Override
    public TaskDTO update(TaskDTO taskDTO) {
        if (taskMapper.updateByPrimaryKeySelective(taskDTO) != 1) {
            throw new CommonException("error.task.update");
        }
        return queryById(taskDTO.getId());
    }

    @Override
    public void deleteById(Long id) {
        taskMapper.deleteByPrimaryKey(id);
    }
}