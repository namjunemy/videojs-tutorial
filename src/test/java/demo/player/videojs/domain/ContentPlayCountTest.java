package demo.player.videojs.domain;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import demo.player.videojs.exception.ContentPlayCountNotFountException;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ContentPlayCountTest {

  @Autowired
  private ContentPlayCountRedisRepository contentPlayCountRedisRepository;

  @After
  public void cleanup() {
    contentPlayCountRedisRepository.deleteById(1000L);
  }

  @Test
  public void read() {
    ContentPlayCount contentPlayCount = ContentPlayCount.builder()
        .idx(1000L)
        .contentIdx(9999L)
        .count(10)
        .build();

    contentPlayCountRedisRepository.save(contentPlayCount);

    ContentPlayCount savedContentPlayCount = contentPlayCountRedisRepository.findById(1000L)
        .orElseThrow(ContentPlayCountNotFountException::new);
    assertThat(savedContentPlayCount.getIdx(), is(1000L));
  }

  @Test
  public void update() {
    ContentPlayCount contentPlayCount = ContentPlayCount.builder()
        .idx(1000L)
        .contentIdx(9999L)
        .count(10)
        .build();
    contentPlayCountRedisRepository.save(contentPlayCount);

    ContentPlayCount savedContentPlayCount = contentPlayCountRedisRepository.findById(1000L)
        .orElseThrow(ContentPlayCountNotFountException::new);

    savedContentPlayCount.countUp();

    assertThat(savedContentPlayCount.getCount(), is(11));
  }
}

