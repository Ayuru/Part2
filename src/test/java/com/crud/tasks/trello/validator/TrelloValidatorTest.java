package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TrelloValidatorTest {

    @InjectMocks
    private TrelloValidator validator;

    @Test
    void validateTrelloBoardsTest() {
        //Given
        TrelloBoard boardOne = new TrelloBoard("001", "Test", new ArrayList<>());
        TrelloBoard boardTwo = new TrelloBoard("002", "Test you luck", new ArrayList<>());
        TrelloBoard boardSeven = new TrelloBoard("007", "James Bond", new ArrayList<>());
        List<TrelloBoard> boards = List.of(boardOne, boardTwo, boardSeven);

        //When
        List<TrelloBoard> validatedBoards = validator.validateTrelloBoards(boards);

        //Then
        assertEquals(2, validatedBoards.size());
    }

    @Test
    void validateTrelloCardTest() {
        //Given
        TrelloCard cardOne = new TrelloCard("blahblah", "pleple", "top", "1");
        TrelloCard cardTwo = new TrelloCard("test", "pleple", "bottom", "0");

        //When&Then
        validator.validateCard(cardOne);
        validator.validateCard(cardTwo);

    }
}
