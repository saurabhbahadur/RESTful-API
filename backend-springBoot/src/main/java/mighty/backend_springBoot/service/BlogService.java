package mighty.backend_springBoot.service;


import mighty.backend_springBoot.dto.requestDto.BlogRequest;
import mighty.backend_springBoot.dto.responseDto.BlogResponse;

public interface BlogService {

    BlogResponse createBlog(BlogRequest blogRequest , String userEmail);
}
