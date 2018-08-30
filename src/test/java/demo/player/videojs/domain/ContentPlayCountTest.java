package demo.player.videojs.domain;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import demo.player.videojs.exception.ContentPlayCountNotFountException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.text.AbstractDocument.Content;
import org.apache.tomcat.jni.Local;
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
  public ContentPlayCountRedisRepository contentPlayCountRedisRepository;

  @After
  public void cleanup() {
    contentPlayCountRedisRepository.deleteAll();
  }

  @Test
  public void 기본_등록_조회() {
    //given
    Long idx = 1L;
    LocalDateTime refreshTime = LocalDateTime.now();
    ContentPlayCount contentPlayCount = ContentPlayCount.builder()
        .idx(idx)
        .contentIdx(10000L)
        .count(1000)
        .refreshTime(refreshTime)
        .build();

    //when
    contentPlayCountRedisRepository.save(contentPlayCount);

    //then
    ContentPlayCount saveContentPlayCount = contentPlayCountRedisRepository.findById(1L)
        .orElseThrow(ContentPlayCountNotFountException::new);
    assertThat(saveContentPlayCount.getCount(), is(1000));
    assertThat(saveContentPlayCount.getRefreshTime(), is(refreshTime));
  }

  @Test
  public void 수정() {
    Long idx = 1L;
    LocalDateTime refreshTime = LocalDateTime.now();

    contentPlayCountRedisRepository.save(ContentPlayCount.builder()
        .idx(idx)
        .contentIdx(10000L)
        .count(100)
        .refreshTime(refreshTime)
        .build());

    //when
    ContentPlayCount contentPlayCount = contentPlayCountRedisRepository.findById(idx)
        .orElseThrow(ContentPlayCountNotFountException::new);
    contentPlayCount.refresh(idx, 200, refreshTime);
    contentPlayCountRedisRepository.save(contentPlayCount);

    //then
    ContentPlayCount refreshContentPlayCount = contentPlayCountRedisRepository.findById(idx)
        .orElseThrow(ContentPlayCountNotFountException::new);
    assertThat(refreshContentPlayCount.getCount(), is(200));
  }
}

