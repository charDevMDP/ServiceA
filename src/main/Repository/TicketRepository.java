package Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}