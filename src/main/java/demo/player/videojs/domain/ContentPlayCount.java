package demo.player.videojs.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@RedisHash("contentPlayCount")
public class ContentPlayCount implements Serializable {

  @Id
  private Long idx;

  private Long contentIdx;
  private int count;
  private LocalDateTime refreshTime;

  @Builder
  public ContentPlayCount(Long idx, Long contentIdx, int count, LocalDateTime refreshTime) {
    this.idx = idx;
    this.contentIdx = contentIdx;
    this.count = count;
    this.refreshTime = refreshTime;
  }

  public void refresh(Long contentIdx, int count, LocalDateTime refreshTime) {
    this.count = count;
    this.refreshTime = refreshTime;
  }
}
