package exposit.customers.controller;

import exposit.customers.dto.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = {"/customers"})
public class CustomersController {

    private final List<Customer> customers = List.of(
            new Customer("1", "John"),
            new Customer("2", "Mike"),
            new Customer("3", "Adam")
    );

    @GetMapping()
    public ResponseEntity<List<Customer>> customers() {
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> customer(@PathVariable() String id) {
        return new ResponseEntity<>(customers.stream()
                .filter(u -> u.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"))
                , HttpStatus.OK);
    }
}
