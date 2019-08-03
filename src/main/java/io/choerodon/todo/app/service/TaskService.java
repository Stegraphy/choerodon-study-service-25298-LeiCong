package io.choerodon.todo.app.service;

import io.choerodon.todo.infra.dto.TaskDTO;

public interface TaskService {

    TaskDTO createOne(TaskDTO taskDTO);

    TaskDTO queryById(Long id);

    TaskDTO queryByTaskNumber(String taskNumber);

    TaskDTO update(TaskDTO taskDTO);

    void deleteById(Long id);
}