package ru.netology.condapp.configs;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.condapp.interfaces.SystemProfile;

@Configuration
public class JavaConfig {
    @Bean("systemProfile")
    @ConditionalOnProperty(value="netology.profile.dev", matchIfMissing = false)
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean("systemProfile")
    @ConditionalOnMissingBean(SystemProfile.class)
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
