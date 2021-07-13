import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TicketTest {

    TicketService ticketService;
    TicketController ticketController;


    @BeforeEach
    public void setUp() {
        ticketService = mock(TicketService.class);
        ticketController = new TicketController(ticketService);
    }


    @Test
    public void getAllTest() {
        Object obj = new Object;

        Pageable pageable = PageRequest.of(1, 10);
        Page<Ticket> PageTicket = new PageImpl(List.of(obj));
        // when
        when(ticketService.getAll(pageable)).thenReturn(PageTicket));

        ResponseEntity<List<Ticket>> response = ticketController.getAll(pageable);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}