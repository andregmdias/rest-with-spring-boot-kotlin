package br.com.giannatech.restwithspringbootkotlin.config

import br.com.giannatech.restwithspringbootkotlin.serialization.converter.YamlJackson2HttpMessageConverter
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {

    override fun extendMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
        converters.add(YamlJackson2HttpMessageConverter())
    }
    override fun configureContentNegotiation(configurer: ContentNegotiationConfigurer) {
//    Configurações content negotiation via query param
//                configurer.favorParameter(true)
//            .parameterName("mediaType")
//            .useRegisteredExtensionsOnly(false)
//            .defaultContentType(MediaType.APPLICATION_JSON)
//            .mediaType("json", MediaType.APPLICATION_JSON)
//            .mediaType("xml", MediaType.APPLICATION_XML)

        configurer.favorParameter(false)
            .useRegisteredExtensionsOnly(false)
            .defaultContentType(MediaType.APPLICATION_JSON)
            .mediaType("json", MediaType.APPLICATION_JSON)
            .mediaType("xml", MediaType.APPLICATION_XML)
            .mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YAML)
    }

    companion object {
        private val MEDIA_TYPE_APPLICATION_YAML : MediaType = MediaType.valueOf("application/x-yaml")
    }
}