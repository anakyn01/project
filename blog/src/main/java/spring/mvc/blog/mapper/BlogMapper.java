package spring.mvc.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import spring.mvc.blog.vo.BlogListRequestVO;
import spring.mvc.blog.vo.BlogListResponseVO;

@Mapper //매퍼로 임명함
public interface BlogMapper {
	int delete(int blgContSeq);
	List<BlogListResponseVO>selectList(BlogListRequestVO blogListRequestVO);
}
