package com.crud.tasks.trello.config;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TrelloConfigTest {


    @InjectMocks
    private TrelloConfig trelloConfig;


    @Test
    void configRetrievedDataTest() {
        //Given
        MockitoAnnotations.openMocks(this);

        //When
        ReflectionTestUtils.setField(trelloConfig, "trelloUser", "T_T");
        ReflectionTestUtils.setField(trelloConfig, "trelloAppKey", "-_-");
        ReflectionTestUtils.setField(trelloConfig, "trelloApiEndpoint", "o_O");
        ReflectionTestUtils.setField(trelloConfig, "trelloToken", "^_^'");

        //Then
        assertEquals("T_T", trelloConfig.getTrelloUser());
        assertEquals("-_-", trelloConfig.getTrelloAppKey());
        assertEquals("o_O", trelloConfig.getTrelloApiEndpoint());
        assertEquals("^_^'", trelloConfig.getTrelloToken());
    }
}
