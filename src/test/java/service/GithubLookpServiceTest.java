package service;

import com.example.demo.DemoApplication;
import com.example.demo.domain.Repo;
import com.example.demo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
public class GithubLookpServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(GithubLookpServiceTest.class);

    @Autowired
    private GithubLookUpService service;

    @Test
    public void githubUserTest() {
        User user = service.getGithubUser();
        String name = user.getName();
        assertThat("Jbee", is(name));
    }

    @Test
    public void getRepoInfo() {
        List<Repo> repos = service.getRepos("", "");
        Repo repo = repos.get(0);
        String name = repo.getName();
        assertThat("TestPublicRepository", is(name));
    }
}
