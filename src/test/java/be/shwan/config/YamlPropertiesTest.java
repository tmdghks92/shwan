package be.shwan.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("local")
class YamlPropertiesTest {
   @Value("${spring.datasource.username}")
    private String username;

    @Value("${file.dir}")
    private String path;
    @Test
    void ymlTest1() {
        assertThat(username).isEqualTo("shwan");
        assertThat(path).isEqualTo("/Users/seunghwanwon/tempDownload/");
    }
}