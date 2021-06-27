package com.example.ecommercejee;

import com.example.ecommercejee.dao.CategorieRepository;
import com.example.ecommercejee.dao.ProductRepository;
import com.example.ecommercejee.entities.Categorie;
import com.example.ecommercejee.entities.Product;
import net.bytebuddy.utility.RandomString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import java.util.Random;

@SpringBootApplication
public class EcommerceJeeApplication implements CommandLineRunner  {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(EcommerceJeeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repositoryRestConfiguration.exposeIdsFor(Product.class, Categorie.class);
        categorieRepository.save(new Categorie(null,"ordinateurs","produit.png",null,null));
        categorieRepository.save(new Categorie(null,"imprimente",null,null,null));
        categorieRepository.save(new Categorie(null,"portable",null,null,null));

        Random rnd=new Random();
        categorieRepository.findAll().forEach(c->{
            for (int i = 0; i <10 ; i++) {
                Product p=new Product();
                p.setName(RandomString.make(18));
                p.setCurrentPrice(100+rnd.nextInt(10000));
                p.setAvailable(rnd.nextBoolean());
                p.setPromotion(rnd.nextBoolean());
                p.setSelected(rnd.nextBoolean());
                p.setCategorie(c);
                p.setPhotoName("produit.png");
                productRepository.save(p);
            }
        });
    }
}

