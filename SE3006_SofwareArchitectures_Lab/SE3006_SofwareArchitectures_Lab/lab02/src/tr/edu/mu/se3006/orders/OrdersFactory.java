package tr.edu.mu.se3006.orders;

import tr.edu.mu.se3006.catalog.CatalogService;

// PUBLIC Factory: Wires the orders module. Needs Catalog API to function.
public class OrdersFactory {
    public static OrderController create(CatalogService catalogService) {
        // TODO: Instantiate OrderRepository
        OrderRepository repository = new OrderRepository();

        // TODO: Instantiate OrderService (inject catalogService and repository)
        OrderService service = new OrderService(catalogService, repository);

        // TODO: Instantiate OrderController (inject service)
        OrderController controller = new OrderController(service);

        // TODO: Return the controller
        return controller;
    }
}