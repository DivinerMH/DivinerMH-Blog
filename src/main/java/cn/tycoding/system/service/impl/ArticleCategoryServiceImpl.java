package cn.tycoding.system.service.impl;

import cn.tycoding.system.entity.ArticleCategory;
import cn.tycoding.system.mapper.ArticleCategoryMapper;
import cn.tycoding.system.service.ArticleCategoryService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author menghuan
 * @since 2019-12-28
 */
@Service
@AllArgsConstructor
@SuppressWarnings("all")
public class ArticleCategoryServiceImpl extends ServiceImpl<ArticleCategoryMapper, ArticleCategory> implements ArticleCategoryService {

    @Autowired
    private ArticleCategoryMapper articleCategoryMapper;

    /**
     * 新增
     *
     * @param articleCategory
     */
    @Override
    @Transactional
    public void add(ArticleCategory articleCategory) {
        if (!exists(articleCategory)) {
            articleCategoryMapper.insert(articleCategory);
        }
    }

    private boolean exists(ArticleCategory articleCategory) {
        LambdaQueryWrapper<ArticleCategory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ArticleCategory::getArticleId, articleCategory.getArticleId());
        queryWrapper.eq(ArticleCategory::getCategoryId, articleCategory.getCategoryId());
        return articleCategoryMapper.selectList(queryWrapper).size() > 0 ? true : false;
    }

    /**
     * 根据文章ID删除
     *
     * @param id
     */
    @Override
    @Transactional
    public void deleteByArticleId(Long id) {
        LambdaQueryWrapper<ArticleCategory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ArticleCategory::getArticleId, id);
        articleCategoryMapper.delete(queryWrapper);
    }

    /**
     * 根据分类ID删除
     *
     * @param id
     */
    @Override
    @Transactional
    public void deleteByCategoryId(Long id) {
        LambdaQueryWrapper<ArticleCategory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ArticleCategory::getCategoryId, id);
        articleCategoryMapper.delete(queryWrapper);
    }
}
