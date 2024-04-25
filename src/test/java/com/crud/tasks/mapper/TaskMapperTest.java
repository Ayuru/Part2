package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TaskMapperTest {

    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    void mapToTaskTest() {
        //Given
        TaskDto taskDto = new TaskDto(666L, "evil", "inside");

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(666L, task.getId());
        assertEquals("evil", task.getTitle());
        assertEquals("inside", task.getContent());
    }

    @Test
    void mapToTaskDtoTest() {
        //Given
        Task task = new Task(666L, "evil", "inside");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(666L, taskDto.getId());
        assertEquals("evil", taskDto.getTitle());
        assertEquals("inside", taskDto.getContent());
    }

    @Test
    void mapToTaskDtoListTest() {
        //Given
        Task taskOne = new Task(666L, "evil", "inside");
        Task taskTwo = new Task(667L, "evil", "outside");
        List<Task> tasks = List.of(taskOne, taskTwo);

        //When
        List<TaskDto> taskDtos = taskMapper.mapToTaskDtoList(tasks);

        //Then
        assertEquals(2, taskDtos.size());
        assertEquals(667L, taskDtos.get(1).getId());
        assertEquals("evil", taskDtos.get(1).getTitle());
        assertEquals("outside", taskDtos.get(1).getContent());
    }
}