package guru.qa.config;

import org.aeonbits.owner.Config;

@ApiConfig.Sources({"classpath:config.properties"})

public interface ApiConfig extends Config {

    @Key("token")
    String getToken();
}
