package be.shwan.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class YamlPropertiesTest {
    @Autowired
    YamlProperties yamlProperties;

    @Value("${spring.datasource.username}")
    private String username;

    @Test
    void ymlTest1() {
        assertThat(username).isEqualTo("shwan");
    }
}