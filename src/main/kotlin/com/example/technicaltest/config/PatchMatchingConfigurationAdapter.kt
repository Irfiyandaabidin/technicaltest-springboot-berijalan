package com.example.technicaltest.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class PatchMatchingConfigurationAdapter (
    val requestInterceptor: RequestInterceptor,
) : WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(requestInterceptor).addPathPatterns("/**").excludePathPatterns("/apiservice/oauth/token")
    }
}