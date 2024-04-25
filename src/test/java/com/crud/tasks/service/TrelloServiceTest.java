package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.*;
import com.crud.tasks.trello.client.TrelloClient;
import com.crud.tasks.trello.config.TrelloConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TrelloServiceTest {

    @InjectMocks
    private TrelloService trelloService;

    @Mock
    private TrelloClient trelloClient;
    @Mock
    private SimpleEmailService emailService;
    @Mock
    private AdminConfig adminConfig;
    @Mock
    private TrelloConfig trelloConfig;

    @Test
    void getTrelloBoardsTest() {
        //Given
        List<TrelloListDto> lists = new ArrayList<>();
        lists.add(new TrelloListDto("x", "secret", false));
        List<TrelloBoardDto> boards = List.of(new TrelloBoardDto("y", "whatever", lists));
        when(trelloClient.getTrelloBoards()).thenReturn(boards);

        //When
        List<TrelloBoardDto> receivedBoards = trelloService.fetchTrelloBoards();

        //Then
        assertNotNull(receivedBoards);
        assertEquals("whatever", receivedBoards.get(0).getName());
    }


    @Test
    void createTrelloCardTest() {
        //Given
        TrelloCardDto card = new TrelloCardDto("card", "description of card", "pos", "2");
        CreatedTrelloCardDto createdCard = new CreatedTrelloCardDto("x", "secret", "blahblah", new Badges());
        when(adminConfig.getAdminMail()).thenReturn("mail");
        when(trelloClient.createNewCard(card)).thenReturn(createdCard);

        //When
        CreatedTrelloCardDto receivedCard = trelloService.createTrelloCard(card);

        //Then
        assertEquals("x", receivedCard.getId());
        assertEquals("secret", receivedCard.getName());
        assertEquals("blahblah", receivedCard.getShortUrl());
    }
}
