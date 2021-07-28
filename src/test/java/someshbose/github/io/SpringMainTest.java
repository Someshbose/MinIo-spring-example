package someshbose.github.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import someshbose.github.io.os.ObjectStorageService;

@SpringBootTest
public class SpringMainTest {

  @Autowired
  private ObjectStorageService service;

  @Test
  public void bucketTest() throws Exception{
    //service.createBucket("asia-test");
    Assertions.assertTrue(service.getBucket("asia-test"));
  }

}
