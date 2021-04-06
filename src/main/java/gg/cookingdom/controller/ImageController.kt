package gg.cookingdom.controller

import gg.cookingdom.service.image.ImageService
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/image")
class ImageController(
    private val imageService: ImageService
) {
    @GetMapping(
        value = ["/{imageName}"],
        produces = [MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_GIF_VALUE]
    )
    fun getImagesByName(@PathVariable imageName: String): ByteArray {
        return imageService.getImage(imageName)
    }
}
