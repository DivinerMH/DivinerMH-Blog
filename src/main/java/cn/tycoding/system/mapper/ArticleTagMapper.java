package cn.tycoding.system.mapper;

import cn.tycoding.system.entity.SysArticle;
import cn.tycoding.system.entity.ArticleTag;
import cn.tycoding.system.entity.SysTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author menghuan
 * @since 2019-12-28
 */
public interface ArticleTagMapper extends BaseMapper<ArticleTag> {

    List<SysTag> findByArticleId(@Param("articleId") long articleId);

    List<SysArticle> findByTagName(@Param("name") String name);
}
