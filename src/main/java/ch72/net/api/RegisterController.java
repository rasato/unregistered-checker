package ch72.net.api;

import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by asato on 2016/07/28.
 */
@RestController
@RequestMapping("file/upload")
public class RegisterController {

    @RequestMapping(method = RequestMethod.POST)
    public String post(@RequestParam("upload_file") MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            // TODO error
        }

        StringBuffer filePath = new StringBuffer("target/classes/public/uploadfile")
                .append(File.separator);

        File uploadDir = makeDir(filePath);

        try {
            File uploadFile = new File(uploadDir.getPath() + "/" + multipartFile.getOriginalFilename());

            System.out.println(uploadFile.getAbsolutePath());

            byte[] bytes = multipartFile.getBytes();
            BufferedOutputStream uploadFileStream =
                    new BufferedOutputStream(new FileOutputStream(uploadFile));
            uploadFileStream.write(bytes);
            uploadFileStream.close();
            return "/uploadfile/" + uploadFile.getName();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
    }

    private File makeDir(StringBuffer filePath) {
        File uploadDir = new File(filePath.toString());
        uploadDir.mkdirs();
        return uploadDir;
    }
}
