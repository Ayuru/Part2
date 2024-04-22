package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TrelloMapperTest {

    @InjectMocks
    TrelloMapper trelloMapper;


    @Test
    void testMapToList() {
        //Given
        TrelloListDto first = new TrelloListDto("Blood", "to Quench", false);
        TrelloListDto second = new TrelloListDto("the Guillotine's", "Thirst", true);
        List<TrelloListDto> lists = new ArrayList<>(List.of(first, second));

        //When
        List<TrelloList> receivedLists = trelloMapper.mapToList(lists);

        //Then
        assertEquals(2, receivedLists.size());
        assertEquals("Blood", receivedLists.get(0).getId());
        assertEquals("to Quench", receivedLists.get(0).getName());
        assertFalse(receivedLists.get(0).isClosed());
        assertEquals("the Guillotine's", receivedLists.get(1).getId());
        assertEquals("Thirst", receivedLists.get(1).getName());
        assertTrue(receivedLists.get(1).isClosed());
    }

    @Test
    void testMapToListDto() {
        //Given
        TrelloList first = new TrelloList("Offer", "the Blood", false);
        TrelloList second = new TrelloList("to", "The Guillotine", true);
        List<TrelloList> lists = new ArrayList<>(List.of(first, second));

        //When
        List<TrelloListDto> receivedLists = trelloMapper.mapToListDto(lists);

        //Then
        assertEquals(2, receivedLists.size());
        assertEquals("Offer", receivedLists.get(0).getId());
        assertEquals("the Blood", receivedLists.get(0).getName());
        assertFalse(receivedLists.get(0).isClosed());
        assertEquals("to", receivedLists.get(1).getId());
        assertEquals("The Guillotine", receivedLists.get(1).getName());
        assertTrue(receivedLists.get(1).isClosed());
    }

    @Test
    void testMapToBoards() {
        //Given
        TrelloListDto first = new TrelloListDto("Blood", "to Quench", false);
        TrelloListDto second = new TrelloListDto("the Guillotine's", "Thirst", true);
        List<TrelloListDto> lists = new ArrayList<>(List.of(first, second));
        TrelloBoardDto board = new TrelloBoardDto("boardId", "boardName", lists);
        List<TrelloBoardDto> boards = new ArrayList<>(List.of(board));

        //When
        List<TrelloBoard> receivedBoards = trelloMapper.mapToBoards(boards);

        //Then
        assertEquals(1, receivedBoards.size());
        assertEquals(2, receivedBoards.get(0).getLists().size());
        assertEquals("Thirst", receivedBoards.get(0).getLists().get(1).getName());

    }

    @Test
    void testMapToBoardsDto() {
        //Given
        TrelloList first = new TrelloList("Offer", "the Blood", false);
        TrelloList second = new TrelloList("to", "The Guillotine", true);
        List<TrelloList> lists = new ArrayList<>(List.of(first, second));
        TrelloBoard board = new TrelloBoard("boardId", "boardName", lists);
        List<TrelloBoard> boards = new ArrayList<>(List.of(board));

        //When
        List<TrelloBoardDto> receivedBoards = trelloMapper.mapToBoardsDto(boards);

        //Then
        assertEquals(1, receivedBoards.size());
        assertEquals(2, receivedBoards.get(0).getLists().size());
        assertEquals("The Guillotine", receivedBoards.get(0).getLists().get(1).getName());

    }

    @Test
    void testMapToCard() {
        //Given
        TrelloCardDto card = new TrelloCardDto("card", "do sth", "pos","x");

        //When
        TrelloCard receivedCard = trelloMapper.mapToCard(card);

        //Then
        assertEquals("card", receivedCard.getName());
        assertEquals("do sth", receivedCard.getDescription());
        assertEquals("pos", receivedCard.getPos());
        assertEquals("x", receivedCard.getListId());

    }

    @Test
    void testMapToCardDto() {
        //Given
        TrelloCard card = new TrelloCard("card", "do sth", "pos","x");

        //When
        TrelloCardDto receivedCard = trelloMapper.mapToCardDto(card);

        //Then
        assertEquals("card", receivedCard.getName());
        assertEquals("do sth", receivedCard.getDescription());
        assertEquals("pos", receivedCard.getPos());
        assertEquals("x", receivedCard.getListId());

    }

}
