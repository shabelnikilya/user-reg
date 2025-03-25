package ru.hollow.security;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import ru.hollow.security.properties.SimpleBasicProperty;

import static ru.hollow.security.properties.Prefix.STARTER_PREFIX;

@AutoConfiguration(
        before = SecurityAutoConfiguration.class
)
@EnableConfigurationProperties(SimpleBasicProperty.class)
@ConditionalOnProperty(
        prefix = STARTER_PREFIX,
        value = "enabled",
        havingValue = "true"
)
@ComponentScan(
        basePackages = {
                "ru.hollow.security.conf",
                "ru.hollow.security.user"
        }
)
public class SimpleBasicSecurityAutoconfiguration {
}
