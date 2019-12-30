package cn.tycoding.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 文章&&分类关联表
 * </p>
 *
 * @author menghuan
 * @since 2019-12-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_article_category")
public class ArticleCategory implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 文章ID
     */
    @NotNull
    @TableField("article_id")
    private Long articleId;

    /**
     * 分类ID
     */
    @NotNull
    @TableField("category_id")
    private Long categoryId;

    public ArticleCategory() {
    }

    public ArticleCategory(Long articleId, Long categoryId) {
        this.articleId = articleId;
        this.categoryId = categoryId;
    }
}
