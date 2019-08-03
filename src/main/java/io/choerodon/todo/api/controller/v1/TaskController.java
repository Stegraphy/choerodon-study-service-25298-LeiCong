package io.choerodon.todo.api.controller.v1;

import io.choerodon.base.annotation.Permission;
import io.choerodon.base.enums.ResourceType;
import io.choerodon.todo.app.service.TaskService;
import io.choerodon.todo.infra.dto.TaskDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/tasks")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @Permission(type = ResourceType.SITE)
    @ApiOperation(value = "创建Task")
    public ResponseEntity<TaskDTO> create(@RequestBody TaskDTO taskDTO) {
        return new ResponseEntity<>(taskService.createOne(taskDTO), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    @Permission(type = ResourceType.SITE)
    @ApiOperation(value = "根据Id查询task")
    public ResponseEntity<TaskDTO> queryById(@PathVariable Long id) {
        return new ResponseEntity<>(taskService.queryById(id), HttpStatus.OK);
    }

    @GetMapping("/taskNumber/{taskNumber}")
    @Permission(type = ResourceType.SITE)
    @ApiOperation(value = "根据TaskNumber查询task")
    public ResponseEntity<TaskDTO> queryByTaskNumber(@PathVariable String taskNumber) {
        return new ResponseEntity<>(taskService.queryByTaskNumber(taskNumber), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Permission(type = ResourceType.SITE)
    @ApiOperation(value = "根据Id删除ask")
    public void delete(@PathVariable Long id) {
        taskService.deleteById(id);
    }


    @PutMapping("/{id}")
    @Permission(type = ResourceType.SITE)
    @ApiOperation(value = "更新task")
    public ResponseEntity<TaskDTO> update(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        taskDTO.setId(id);
        return new ResponseEntity<>(taskService.update(taskDTO), HttpStatus.OK);
    }
}