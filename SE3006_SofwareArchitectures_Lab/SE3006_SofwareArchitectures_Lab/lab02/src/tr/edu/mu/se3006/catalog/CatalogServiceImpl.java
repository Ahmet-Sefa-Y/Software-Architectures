package tr.edu.mu.se3006.catalog;

// Package-private implementation. Hidden from the outside world.
class CatalogServiceImpl implements CatalogService {

    private final ProductRepository repository;

    CatalogServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void checkAndReduceStock(Long productId, int quantity) {
        Product product = repository.findById(productId);

        if (product == null) {
            throw new IllegalArgumentException("Ürün bulunamadı! ID: " + productId);
        }

        if (product.getStock() < quantity) {
            throw new IllegalArgumentException("Yetersiz stok! Mevcut: " + product.getStock() + ", İstenen: " + quantity);
        }

        int newStock = product.getStock() - quantity;
        product.setStock(newStock);

        repository.save(product);


        System.out.println("[Catalog] Stok güncellendi. Ürün ID: " + productId + " | Kalan Stok: " + newStock);
    }
}