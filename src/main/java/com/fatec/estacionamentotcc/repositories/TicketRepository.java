package com.fatec.estacionamentotcc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.estacionamentotcc.domain.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
