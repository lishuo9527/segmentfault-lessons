package com.segmentfault.springbootlesson1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;

@SpringBootApplication
public class TestApplication implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private final YamlPropertySourceLoader loader = new YamlPropertySourceLoader();

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        Resource wxresource = configurableApplicationContext.getResource("classpath:wx");

        PropertySource<?> wxProperties = loadYaml("wx-recource", wxresource);

        configurableApplicationContext.getEnvironment().getPropertySources().addFirst(wxProperties);
    }

    private PropertySource<?> loadYaml(String name, Resource path) {
        if (!path.exists()) {
            throw new IllegalArgumentException("Resource " + path + " does not exist");
        }
        try {
            return this.loader.load(name, path, null);
        } catch (IOException ex) {
            throw new IllegalStateException("Failed to load yaml configuration from " + path, ex);
        }

    }

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

}
