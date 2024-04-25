package com.crud.tasks.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AttachmentsByTypeTest {

    @InjectMocks
    private AttachmentsByType attachmentsByType;

    @Test
    public void attachmentsByTypeSimpleTest() {
        // Given
        Trello trello = new Trello();
        trello.setBoard(1);
        trello.setCard(1);
        attachmentsByType.setTrello(trello);

        // When
        Trello attachedTrello = attachmentsByType.getTrello();

        // Then
        assertEquals(1, attachedTrello.getBoard());
        assertEquals(1, attachedTrello.getCard());
    }
}