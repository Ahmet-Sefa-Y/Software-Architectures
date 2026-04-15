package tr.edu.mu.se3006.catalog;

// PUBLIC Factory: Assembles the internal components and exposes ONLY the interface.
public class CatalogFactory {
    public static CatalogService create() {
        // TODO: Instantiate ProductRepository
        ProductRepository repository = new ProductRepository();

        // TODO: Instantiate CatalogServiceImpl using the repository
        CatalogServiceImpl service = new CatalogServiceImpl(repository);

        // TODO: Return the CatalogServiceImpl instance
        return service;
    }
}