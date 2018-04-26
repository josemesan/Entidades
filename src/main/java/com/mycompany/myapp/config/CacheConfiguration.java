package com.mycompany.myapp.config;

import io.github.jhipster.config.JHipsterProperties;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.expiry.Duration;
import org.ehcache.expiry.Expirations;
import org.ehcache.jsr107.Eh107Configuration;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;

@Configuration
@EnableCaching
@AutoConfigureAfter(value = { MetricsConfiguration.class })
@AutoConfigureBefore(value = { WebConfigurer.class, DatabaseConfiguration.class })
public class CacheConfiguration {

    private final javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration;

    public CacheConfiguration(JHipsterProperties jHipsterProperties) {
        JHipsterProperties.Cache.Ehcache ehcache =
            jHipsterProperties.getCache().getEhcache();

        jcacheConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(
            CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class,
                ResourcePoolsBuilder.heap(ehcache.getMaxEntries()))
                .withExpiry(Expirations.timeToLiveExpiration(Duration.of(ehcache.getTimeToLiveSeconds(), TimeUnit.SECONDS)))
                .build());
    }

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            cm.createCache("users", jcacheConfiguration);
            cm.createCache(com.mycompany.myapp.domain.User.class.getName(), jcacheConfiguration);
            cm.createCache(com.mycompany.myapp.domain.Authority.class.getName(), jcacheConfiguration);
            cm.createCache(com.mycompany.myapp.domain.User.class.getName() + ".authorities", jcacheConfiguration);
            cm.createCache(com.mycompany.myapp.domain.Observaciones.class.getName(), jcacheConfiguration);
            cm.createCache(com.mycompany.myapp.domain.Estacion.class.getName(), jcacheConfiguration);
            cm.createCache(com.mycompany.myapp.domain.Linea.class.getName(), jcacheConfiguration);
            cm.createCache(com.mycompany.myapp.domain.Linea.class.getName() + ".estacions", jcacheConfiguration);
            cm.createCache(com.mycompany.myapp.domain.Linea.class.getName() + ".datos", jcacheConfiguration);
            cm.createCache(com.mycompany.myapp.domain.Linea.class.getName() + ".tablaTrenes", jcacheConfiguration);
            cm.createCache(com.mycompany.myapp.domain.Linea.class.getName() + ".intervaloOfertados", jcacheConfiguration);
            cm.createCache(com.mycompany.myapp.domain.IntervaloOfertado.class.getName(), jcacheConfiguration);
            cm.createCache(com.mycompany.myapp.domain.RelacionFechaTipodia.class.getName(), jcacheConfiguration);
            cm.createCache(com.mycompany.myapp.domain.TablaTrenes.class.getName(), jcacheConfiguration);
            cm.createCache(com.mycompany.myapp.domain.IntervaloMin.class.getName(), jcacheConfiguration);
            cm.createCache(com.mycompany.myapp.domain.IntervaloMax.class.getName(), jcacheConfiguration);
            cm.createCache(com.mycompany.myapp.domain.Datos.class.getName(), jcacheConfiguration);
            cm.createCache(com.mycompany.myapp.domain.Datos.class.getName() + ".observaciones", jcacheConfiguration);
            // jhipster-needle-ehcache-add-entry
        };
    }
}
