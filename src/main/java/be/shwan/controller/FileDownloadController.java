package be.shwan.controller;

import be.shwan.config.Constant;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

@Controller
@RequiredArgsConstructor
public class FileDownloadController {

    @Value("${dart.key}")
    String key;

    @Value("${file.dir}")
    String dir;


    @PostMapping("/download")
    public void zipFileDownLoad() throws IOException {
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
