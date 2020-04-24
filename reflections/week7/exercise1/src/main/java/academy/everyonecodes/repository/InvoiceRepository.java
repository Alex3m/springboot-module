package academy.everyonecodes.repository;

import academy.everyonecodes.data.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
