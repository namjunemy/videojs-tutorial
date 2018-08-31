package demo.player.videojs.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@ConfigurationProperties(prefix = "app")
@Validated
public class AppProperty {

  private RedisConf redisConf;

  @Getter
  @Setter
  public static class RedisConf {

    private String host;
    private int port;
    private String password;
  }
}
