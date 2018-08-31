package demo.player.videojs.service;

import demo.player.videojs.domain.ContentPlayCount;
import demo.player.videojs.domain.ContentPlayCountRedisRepository;
import demo.player.videojs.exception.ContentPlayCountNotFountException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class MainService {

  private final ContentPlayCountRedisRepository contentPlayCountRedisRepository;

  public ContentPlayCount findById(Long idx) {
    ContentPlayCount contentPlayCount = contentPlayCountRedisRepository.findById(idx)
        .orElseThrow(ContentPlayCountNotFountException::new);
    return contentPlayCount;
  }

  public void countUp(Long idx) {
    ContentPlayCount contentPlayCount = findById(idx);
    contentPlayCount.countUp();
    contentPlayCountRedisRepository.save(contentPlayCount);
  }
}
