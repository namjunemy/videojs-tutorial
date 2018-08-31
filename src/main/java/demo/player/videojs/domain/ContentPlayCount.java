package demo.player.videojs.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import java.io.Serializable;

@Getter
@RedisHash("ContentPlayCount")
public class ContentPlayCount implements Serializable {

  @Id
  private Long idx;
  private Long contentIdx;
  private int count;

  @Builder
  public ContentPlayCount(Long idx, Long contentIdx, int count) {
    this.idx = idx;
    this.contentIdx = contentIdx;
    this.count = count;
  }

  public void countUp() {
    this.count += 1;
  }
}
