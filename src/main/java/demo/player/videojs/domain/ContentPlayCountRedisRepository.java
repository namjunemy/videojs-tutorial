package demo.player.videojs.domain;

import org.springframework.data.repository.CrudRepository;

public interface ContentPlayCountRedisRepository extends CrudRepository<ContentPlayCount, Long> {

}
