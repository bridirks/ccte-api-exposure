package gov.epa.ccte.api.exposure.config.converter;

import gov.epa.ccte.api.exposure.domain.ImageFormat;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToImageFormatConverter implements Converter<String, ImageFormat> {
    @Override
    public ImageFormat convert(String source) {
        return ImageFormat.valueOf(source.toUpperCase());
    }
}
