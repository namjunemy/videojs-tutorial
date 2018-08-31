package demo.player.videojs.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@RequiredArgsConstructor
@Configuration
@EnableRedisRepositories
@EnableConfigurationProperties(AppProperty.class)
public class JedisConfig {

  private final AppProperty appProperty;

  @Bean
  public JedisConnectionFactory jedisConnectionFactory() {
    RedisStandaloneConfiguration redisStandaloneConfiguration =
        new RedisStandaloneConfiguration(
            appProperty.getRedisConf().getHost(),
            appProperty.getRedisConf().getPort()
        );

    redisStandaloneConfiguration
        .setPassword(RedisPassword.of(appProperty.getRedisConf().getPassword()));

    return new JedisConnectionFactory(redisStandaloneConfiguration);
  }

  @Bean
  public RedisTemplate<?, ?> redisTemplate() {
    RedisTemplate<byte[], byte[]> template = new RedisTemplate<>();
    template.setKeySerializer(new StringRedisSerializer());
    template.setValueSerializer(new StringRedisSerializer());
    template.setConnectionFactory(jedisConnectionFactory());
    return template;
  }
}
