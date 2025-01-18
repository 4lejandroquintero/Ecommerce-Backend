package com.deval.ecommerce.Backend.application.product;

import com.deval.ecommerce.Backend.application.UploadFile;
import com.deval.ecommerce.Backend.domain.model.product.Product;
import com.deval.ecommerce.Backend.domain.port.product.IProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Paths;

@Slf4j
public class ProductService {
    private final IProductRepository iProductRepository;
    private final UploadFile uploadFile;

    public ProductService(IProductRepository iProductRepository, UploadFile uploadFile) {
        this.iProductRepository = iProductRepository;
        this.uploadFile = uploadFile;
    }

    @Transactional
    public Product save(Product product, MultipartFile multipartFile) throws IOException {
        if (product.getId() != null && product.getId() != 0) { // Producto existente
            Product existingProduct = iProductRepository.findById(product.getId());
            if (existingProduct != null) {
                // Actualizar campos
                existingProduct.setCode(product.getCode());
                existingProduct.setName(product.getName());
                existingProduct.setDescription(product.getDescription());
                existingProduct.setPrice(product.getPrice());
                existingProduct.setCategoryId(product.getCategoryId());
                existingProduct.setUserId(product.getUserId());

                // Comprobar si se subió una nueva imagen
                if (multipartFile != null) {
                    // Eliminar la imagen anterior si no es la predeterminada
                    if (existingProduct.getUrlImage() != null && !existingProduct.getUrlImage().endsWith("default.jpg")) {
                        String nameFile = Paths.get(existingProduct.getUrlImage()).getFileName().toString();
                        uploadFile.delete(nameFile);
                    }
                    // Subir nueva imagen y asignarla
                    existingProduct.setUrlImage(uploadFile.upload(multipartFile));
                }

                return iProductRepository.save(existingProduct);
            }
        }

        // Producto nuevo
        if (multipartFile != null) {
            product.setUrlImage(uploadFile.upload(multipartFile));
        } else {
            // Configurar imagen predeterminada si no se proporciona una nueva
            product.setUrlImage(uploadFile.upload(multipartFile));
        }
        return iProductRepository.save(product);
    }

    public Iterable<Product> findAll(){
        return this.iProductRepository.findAll();
    }

    public Product findById(Integer id){
        return this.iProductRepository.findById(id);
    }

    public void deleteById(Integer id) {
        Product product = findById(id);
        if (product.getUrlImage() != null && !product.getUrlImage().endsWith("default.jpg")) {
            String name = Paths.get(product.getUrlImage()).getFileName().toString(); // Extraer el nombre del archivo
            log.info("Eliminando imagen: {}", name);
            uploadFile.delete(name);
        }

        this.iProductRepository.deleteById(id);
    }
}