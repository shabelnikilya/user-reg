package ru.hollow.security.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import static ru.hollow.security.properties.Prefix.STARTER_PREFIX;

@ConfigurationProperties(prefix = STARTER_PREFIX)
public class SimpleBasicProperty {

    private boolean enabled;

    private String openUrlPattern;

    private String urlForUsers;

    private String urlForAdmins;

    public SimpleBasicProperty() {
    }

    public SimpleBasicProperty(boolean enabled, String openUrlPattern, String urlForUsers, String urlForAdmins) {
        this.enabled = enabled;
        this.openUrlPattern = openUrlPattern;
        this.urlForUsers = urlForUsers;
        this.urlForAdmins = urlForAdmins;
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

    public String getUrlForUsers() {
        return urlForUsers;
    }

    public void setUrlForUsers(String urlForUsers) {
        this.urlForUsers = urlForUsers;
    }

    public String getUrlForAdmins() {
        return urlForAdmins;
    }

    public void setUrlForAdmins(String urlForAdmins) {
        this.urlForAdmins = urlForAdmins;
    }

    @Override
    public String toString() {
        return "SimpleBasicProperty{" +
                "enabled=" + enabled +
                ", openUrlPattern='" + openUrlPattern + '\'' +
                ", urlForUsers='" + urlForUsers + '\'' +
                ", urlForAdmins='" + urlForAdmins + '\'' +
                '}';
    }
}
