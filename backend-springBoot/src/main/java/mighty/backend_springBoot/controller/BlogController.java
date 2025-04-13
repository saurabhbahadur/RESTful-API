package mighty.backend_springBoot.controller;


import lombok.extern.slf4j.Slf4j;
import mighty.backend_springBoot.dto.requestDto.BlogRequest;
import mighty.backend_springBoot.dto.responseDto.BlogResponse;
import mighty.backend_springBoot.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/create")
    public BlogResponse createBlog(@RequestBody BlogRequest blogRequest, @AuthenticationPrincipal User user) {
        log.info("Blog Controller called");
        return blogService.createBlog(blogRequest, user.getUsername());
    }
}
