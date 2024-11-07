package spring.mvc.blog.service;

import java.util.List;
import java.util.Map;

import spring.mvc.blog.vo.BlogEditRequestVO;
import spring.mvc.blog.vo.BlogListRequestVO;
import spring.mvc.blog.vo.BlogListResponseVO;

public interface BlogService {
 int create(Map<String, Object>map);

Map<String, Object> read(int blogContSeq);//read 시그니처

boolean edit(BlogEditRequestVO blogEditRequestVO);//edit 시그니처

List<BlogListResponseVO> list(BlogListRequestVO blogListRequestVO);//list 시그니처

boolean delete(int blogContSeq);//delete 시그니처

}
