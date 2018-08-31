package demo.player.videojs.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentPlayCountRedisRepository extends CrudRepository<ContentPlayCount, Long> {

}
