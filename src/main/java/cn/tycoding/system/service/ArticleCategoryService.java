package cn.tycoding.system.service;

import cn.tycoding.system.entity.ArticleCategory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author menghuan
 * @since 2019-12-28
 */
public interface ArticleCategoryService extends IService<ArticleCategory> {

    /**
     * 新增
     *
     * @param articleCategory
     */
    void add(ArticleCategory articleCategory);

    /**
     * 根据文章ID删除
     *
     * @param id
     */
    void deleteByArticleId(Long id);

    /**
     * 根据分类ID删除
     *
     * @param id
     */
    void deleteByCategoryId(Long id);
}
