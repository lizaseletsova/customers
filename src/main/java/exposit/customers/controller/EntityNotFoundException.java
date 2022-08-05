package exposit.customers.controller;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String customer_not_found) {
        super("Entity Not found" + customer_not_found);
    }
}
