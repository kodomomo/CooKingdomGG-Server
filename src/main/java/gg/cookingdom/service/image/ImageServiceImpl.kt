package gg.cookingdom.service.image

import lombok.SneakyThrows
import okhttp3.OkHttpClient
import okhttp3.Request
import org.apache.commons.io.IOUtils
import org.springframework.beans.factory.annotation.Value
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import java.io.FileNotFoundException
import java.io.InputStream

@Service
open class ImageServiceImpl(
    @Value("\${aws.s3.static.url}")
    private val requestUrl: String
): ImageService {

    @SneakyThrows
    @Cacheable(value = ["cache"])
    override fun getImage(imageName: String): ByteArray {
        val client = OkHttpClient()
        val url: String = requestUrl + "image/$imageName"

        val request = Request.Builder()
            .url(url).get()
            .build()
        val response: InputStream = client.newCall(request)
            .execute().body()?.byteStream()
            ?: throw FileNotFoundException()

        return IOUtils.toByteArray(response)
    }
}
