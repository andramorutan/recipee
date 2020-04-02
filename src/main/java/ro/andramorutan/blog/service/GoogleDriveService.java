package ro.andramorutan.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class GoogleDriveService
{
  private static final String GITLAB_URL = "https://www.googleapis.com/drive/v3/files";


  //private RestTemplate restTemplate;
 /* @Autowired
  public GoogleDriveService(RestTemplateBuilder builder) {
    this.restTemplate = builder.build();
  }*/

  public void getMergeRequestList() {

  }
}
