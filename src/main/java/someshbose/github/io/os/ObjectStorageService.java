package someshbose.github.io.os;

import io.minio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjectStorageService {

  @Autowired
  private MinioClient minioClient;

  public void createBucket(String bucketName) throws Exception{
    minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
  }

  public boolean getBucket(String bucketName)throws Exception{
    return minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
  }

  public ObjectWriteResponse uploadObject(UploadObjectArgs arg)  throws  Exception{
    ObjectWriteResponse response = minioClient.uploadObject(arg);
    return response;
  }
}
