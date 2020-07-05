package com.example.demo.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
// Establece que la caché utilizará AspectJ
@EnableCaching(mode = AdviceMode.ASPECTJ)
public class CacheManagerConfig {

    public static final String USER_CACHE = "userCache";

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        
        // Configuracion de la cache, se establece tamaño maximo en cantidad de entradas,
        // tiempo de expiracion.
        // La configuración de cache debe heredar de CacheManager
        CaffeineCache userCache = new CaffeineCache(USER_CACHE, Caffeine.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(30, TimeUnit.MINUTES)
                .build());

        cacheManager.setCaches(List.of(userCache));
        return cacheManager;
    }
}
