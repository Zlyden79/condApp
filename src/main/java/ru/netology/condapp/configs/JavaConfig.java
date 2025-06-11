package ru.netology.condapp.configs;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.condapp.interfaces.SystemProfile;

@Configuration
public class JavaConfig {
    @Bean("systemProfile")
    @ConditionalOnProperty(value="netology.profile.dev", havingValue = "true"/*, matchIfMissing = false*/)
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean("systemProfile")
    //@ConditionalOnMissingBean(SystemProfile.class)
    @ConditionalOnProperty(value="netology.profile.dev", havingValue = "false", matchIfMissing = true)
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
