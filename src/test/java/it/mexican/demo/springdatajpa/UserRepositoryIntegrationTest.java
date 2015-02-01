package it.mexican.demo.springdatajpa;

import it.mexican.demo.springdatajpa.entities.User;
import it.mexican.demo.springdatajpa.repositories.UserRepository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	loader=AnnotationConfigContextLoader.class, 
	classes = {AppConfig.class})
public class UserRepositoryIntegrationTest {

  @Autowired UserRepository repository;

  @Test
  public void sampleTestCase() {
    User dave = new User("Dave", "Matthews");
    dave = repository.save(dave);

    User carter = new User("Carter", "Beauford");
    carter = repository.save(carter);

    List<User> result = repository.findByLastname("Matthews");
//    assertThat(result.size(), is(1));
//    assertThat(result, hasItem(dave));
  }
}