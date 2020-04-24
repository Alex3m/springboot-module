package academy.everyonecodes.logic;

import academy.everyonecodes.data.Invoice;
import academy.everyonecodes.data.Patient;
import academy.everyonecodes.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Accountant {
    private final double cost;
    private final InvoiceRepository repository;

    public Accountant(
            @Value("${treatment.cost}") double cost,
            InvoiceRepository repository) {
        this.cost = cost;
        this.repository = repository;
    }

    public Invoice generateInvoice(Patient patient) {
        Invoice newInvoice = new Invoice(cost, false, patient);
        repository.save(newInvoice);
        return newInvoice;
    }

    public void markAsPaid(Long id) {
        Optional<Invoice> oInvoice = repository.findById(id);
        oInvoice.ifPresent(invoice -> invoice.setPaid(true));
    }

    public List<Invoice> getAll() {
        return repository.findAll();
    }
}
