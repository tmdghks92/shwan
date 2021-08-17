package be.shwan.controller;

import be.shwan.config.Constant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

@SpringBootTest
@ActiveProfiles("local")
class FileDownloadControllerTest {

    @Value("${dart.key}")
    String key;

    @Value("${file.dir}")
    String dir;

    @Test
    void download() throws Exception {
        String path = "/api/corpCode.xml";
        String param = "crtfc_key";
        String fileName = "test.zip";
        String FILE_URL = Constant.DART_URL + path + "?" + param + "=" +key;
        URL url = new URL(FILE_URL);
        ReadableByteChannel channel = Channels.newChannel(url.openStream());
        FileOutputStream fileOutputStream = new FileOutputStream(dir + fileName);
        fileOutputStream.getChannel().transferFrom(channel, 0, Long.MAX_VALUE);
        fileOutputStream.close();
    }
}