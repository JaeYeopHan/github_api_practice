package service;

import com.example.demo.domain.Repo;
import com.example.demo.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;

@Service
public class GithubLookUpService {
    private static final Logger logger = LoggerFactory.getLogger(GithubLookUpService.class);

    private static final String GITHUB_REPO_API = "https://api.github.com/orgs/TestOrgOfJbee/repos";
    private static final String API = "https://api.github.com/users/JaeYeopHan";
    private static final String REPO_API = "https://api.github.com/users/JaeYeopHan/repos";

    private static final String TOKEN = "token 2a23e77b67e7fded69020b3768796f9bc2551c5f";

    private RestTemplate restTemplate = new RestTemplate();

    public List<Repo> getRepos(String user, String repo) {
        return asList(restTemplate.getForObject(REPO_API, Repo[].class, user, repo));
    }

    public User getGithubUser() {
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.AUTHORIZATION, TOKEN);
        HttpEntity<User> entity = new HttpEntity<>(header);
        ResponseEntity<User> response = restTemplate.exchange(API, HttpMethod.GET, entity, User.class);

        logger.debug("sample data: {}", response.getBody());
        return response.getBody();
    }
}
