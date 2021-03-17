package gg.cookingdom.service.image;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

@Service
public class ImagesService {

    @SneakyThrows
    public byte[] getImage(String imageName){
        return IOUtils.toByteArray(getClass().getResourceAsStream(imageName));


    }
}
