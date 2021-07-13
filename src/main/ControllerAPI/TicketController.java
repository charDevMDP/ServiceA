package ControllerAPI;

import ControllerAPI.Ticket;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Service.TicketService;

import java.net.URI;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;


    // traigo todos los ticket con descuentos
    @ApiResponses(value ={
            @ApiResponse(code = 200, 'OK')
    })
    @GetMapping
    public ResponseEntity<Ticket> getAll(Pageable pageable) {
        Page<Ticket> ticket = ticketService.getAll(pageable);
        return response(ticket);
    }




}