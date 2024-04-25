package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DbServiceTest {

    @InjectMocks
    private DbService dbService;

    @Mock
    TaskRepository taskRepository;

    @Test
    void getAllTasksTest() {
        //Given
        List<Task> tasks = List.of(new Task(1L, "?", "What to do?"));
        when(taskRepository.findAll()).thenReturn(tasks);

        //When
        List<Task> receivedTasks = dbService.getAllTasks();

        //Then
        assertEquals(1, receivedTasks.size());
        assertEquals("?", receivedTasks.get(0).getTitle());
        assertEquals("What to do?", receivedTasks.get(0).getContent());
    }

    @Test
    void getTaskTest() throws TaskNotFoundException {
        //Given
        Task mockedTask = new Task(1L, "?", "What to do?");
        when(taskRepository.findById(mockedTask.getId())).thenReturn(Optional.of(mockedTask));

        //When
        Task receivedTask = dbService.getTask(mockedTask.getId());

        //Then
        assertNotNull(receivedTask);
        assertEquals("?", receivedTask.getTitle());
        assertEquals("What to do?", receivedTask.getContent());

    }

    @Test
    void saveTaskTest() {
        //Given
        Task task = new Task(1L, "?", "What to do?");
        when(taskRepository.save(task)).thenReturn(task);

        //When
        Task savedTask = dbService.saveTask(task);

        //Then
        assertNotNull(savedTask);
        assertEquals(task.getId(), savedTask.getId());
        assertEquals("?", savedTask.getTitle());
        assertEquals("What to do?", savedTask.getContent());

    }

    @Test
    void deleteTaskTest() {
        //Given
        Task task = new Task(1L, "title", "content");
        when(taskRepository.save(task)).thenReturn(task);
        when(taskRepository.findAll()).thenReturn(List.of());
        Task savedTask = dbService.saveTask(task);

        //When
        dbService.deleteTask(savedTask.getId());
        List<Task> list = dbService.getAllTasks();

        //Then
        assertEquals(list.size(), 0);

    }

}