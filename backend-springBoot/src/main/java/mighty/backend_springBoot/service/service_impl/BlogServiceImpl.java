package mighty.backend_springBoot.service.service_impl;


import lombok.extern.slf4j.Slf4j;
import mighty.backend_springBoot.dto.requestDto.BlogRequest;
import mighty.backend_springBoot.dto.responseDto.BlogResponse;
import mighty.backend_springBoot.models.Blog;
import mighty.backend_springBoot.models.Users;
import mighty.backend_springBoot.respository.BlogRepository;
import mighty.backend_springBoot.respository.UserRepository;
import mighty.backend_springBoot.service.BlogService;
import mighty.backend_springBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
   private UserRepository userRepository;

    @Override
    public BlogResponse createBlog(BlogRequest blogRequest, String userEmail) {

        log.info("User created post by email:" +userEmail);
        Users user = userRepository.findByEmail(userEmail).orElseThrow( ()-> new RuntimeException("User not found") );

        Blog blog = new Blog();
        blog.setTitle(blogRequest.getTitle());
        blog.setMessage(blogRequest.getMessage());
        blog.setUser(user);

        Blog saved = blogRepository.save(blog);


        return new BlogResponse(saved.getTitle(),saved.getMessage(),user.getUsername(),saved.getCreatedAt());

    }
}
