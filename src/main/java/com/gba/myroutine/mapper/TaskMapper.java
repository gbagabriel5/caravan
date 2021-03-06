package com.gba.myroutine.mapper;

import com.gba.myroutine.domain.Task;
import com.gba.myroutine.domain.User;
import com.gba.myroutine.dto.TaskDTO;
import com.gba.myroutine.dto.UserCustomDTO;
import org.modelmapper.ModelMapper;

public class TaskMapper {
    private ModelMapper modelMapper = new ModelMapper();
    public TaskDTO convertToDTO(Task entity) {
        TaskDTO dto = new TaskDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setData(entity.getData());
        if(entity.getUser() != null)
            dto.setUserDTO(modelMapper.map(entity.getUser(), UserCustomDTO.class));
        return dto;
    }

    public Task convertToEntity(TaskDTO dto) {
        Task entity = new Task();
        if(dto.getId() == 0)
            entity.setId(null);
        else
            entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setData(dto.getData());
        if(dto.getUserDTO() != null)
            entity.setUser(modelMapper.map(dto.getUserDTO(), User.class));
        return entity;
    }

    public Task convertToUpdate(Task task, Task taskReturn) {
        task.setId(taskReturn.getId());
        if(task.getTitle() == null)
            task.setTitle(taskReturn.getTitle());
        if(task.getDescription() == null)
            task.setDescription(taskReturn.getDescription());
        if(task.getData() == null)
            task.setData(taskReturn.getData());
        task.setUser(taskReturn.getUser());
        return task;
    }
}