package gg.cookingdom.service.image

interface ImageService {
    fun getImage(imageName: String): ByteArray
}
