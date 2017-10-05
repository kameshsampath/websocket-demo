package com.example.demo;

import io.openshift.booster.catalog.BoosterCatalogService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class WebsocketDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketDemoApplication.class, args);
    }


    @Configuration
    public class BoosterCatalogConfiguration {

        @Bean
        public BoosterCatalogSocketHandler boosterCatalogSocketHandler(BoosterCatalogService boosterCatalogService) {
            return new BoosterCatalogSocketHandler(boosterCatalogService);
        }

        @Bean
        public BoosterCatalogService boosterCatalogService() {
            BoosterCatalogService boosterCatalogService =
                    new BoosterCatalogService.Builder()
                            .catalogRepository("https://github.com/openshiftio/booster-catalog")
                            .catalogRef("next")
                            .build();
            //boosterCatalogService.index();
            return boosterCatalogService;
        }
    }
}
