package com.hamexhanif.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.hamexhanif.ecommerce.entity.Product;
import com.hamexhanif.ecommerce.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        
        HttpMethod[] theUnsupportedAcMethods = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};

        // for Product: only GET methods allowed, others disabled 
        config.getExposureConfiguration()
              .forDomainType(Product.class)
              .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedAcMethods))
              .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedAcMethods));

        // for ProductCategory: only GET methods allowed, others disabled 
        config.getExposureConfiguration()
              .forDomainType(ProductCategory.class)
              .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedAcMethods))
              .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedAcMethods));

    }
}
