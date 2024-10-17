package com.selenium.automation.config.converter;

import lombok.SneakyThrows;
import org.aeonbits.owner.Converter;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URL;

public class UrlConverter implements Converter<URL> {

    @SneakyThrows
    @Override
    public URL convert(Method method, String remoteUrl) {
        return new URI(remoteUrl).toURL();
    }
}
