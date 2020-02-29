package life.my.community.controller;

import life.my.community.dto.AccessTokenDTO;
import life.my.community.dto.GithubUser;
import life.my.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("ed90d610d75d28d79317");
        accessTokenDTO.setClient_secret("bb413ad15b03c8c7b3adfc7d2b51e1d88ae4b419");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedircet_url("http://localhost:8887/callback");
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
