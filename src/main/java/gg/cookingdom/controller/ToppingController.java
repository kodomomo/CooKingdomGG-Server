package gg.cookingdom.controller;

import gg.cookingdom.service.image.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topping")
@RequiredArgsConstructor
public class ToppingController {

    private final ImageService imageService;

    @GetMapping(
            value = "/{imageName}",
            produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_GIF_VALUE}
    )
    public byte[] getToppingByName(@PathVariable String imageName) {
        return (byte[]) imageService.getImage(imageName + ".png");
    }
}
