package ru.shop.sevices;

import org.springframework.stereotype.Service;
import ru.shop.domain.Domain;
import ru.shop.domain.Product;
import ru.shop.domain.ProductType;
import ru.shop.exception.EntityNotFoundException;
import ru.shop.repository.CommonRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService implements CommonService {
    private final CommonRepository productRepository;

    public ProductService(CommonRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Domain domain) {
        productRepository.save(domain);
    }

    @Override
    public List<Domain> findAll() {
        return productRepository.findAll();
    }
    public Optional<Product>  findById(UUID id) throws EntityNotFoundException {
        List<Product> products = productRepository.findAll().stream().map(d -> (Product)d).collect(Collectors.toList());

        return Optional.of(products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(()-> new EntityNotFoundException("product not found")));
    }
    public List<Product> findByProductType(ProductType productType) {
        List<Product> products = productRepository.findAll().stream().map(d -> (Product)d).collect(Collectors.toList());
        return products.stream().filter(p -> p.getProductType() == productType).collect(Collectors.toList());
    }

}
