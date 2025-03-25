package ru.hollow.security.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import static ru.hollow.security.properties.Prefix.STARTER_PREFIX;

@ConfigurationProperties(prefix = STARTER_PREFIX)
public class SimpleBasicProperty {

    private boolean enabled;

    private String openUrlPattern;

    public SimpleBasicProperty() {
    }

    public SimpleBasicProperty(boolean enabled, String openUrlPattern) {
        this.enabled = enabled;
        this.openUrlPattern = openUrlPattern;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getOpenUrlPattern() {
        return openUrlPattern;
    }

    public void setOpenUrlPattern(String openUrlPattern) {
        this.openUrlPattern = openUrlPattern;
    }
}
