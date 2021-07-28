package someshbose.github.io;

import io.minio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import someshbose.github.io.os.ObjectStorageService;

import java.io.IOException;

@SpringBootApplication
public class SpringMainApp implements CommandLineRunner {

  @Autowired
  private ObjectStorageService service;

  @Autowired
  private Environment env;

  public static void main(String[] args) {
    SpringApplication.run(SpringMainApp.class, args);
  }

  @Override public void run(String... args) throws Exception {

    final String bucketName = env.getProperty("minio.bucketName");

      if (!service.getBucket(bucketName)) {
        service.createBucket(bucketName);
      } else {
        System.out.println("Bucket "+ bucketName+" already exists.");
      }

    final UploadObjectArgs obj = createUploadObjectArgsObj(bucketName);

    final ObjectWriteResponse response = service.uploadObject(obj);

    if (response.etag()!=null){
      System.out.println("file is successfully uploaded !!!!");
    }else{
      System.out.println("file is upload failed !!!!");
    }

  }

  private UploadObjectArgs createUploadObjectArgsObj(String bucketName) throws IOException {
    return UploadObjectArgs.builder()
        .bucket(bucketName)
        .object("asiaphotos.zip")
        .filename("C:/Users/iamso/Pictures/Sample.png")
        .build();
  }
}
