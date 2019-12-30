package cn.tycoding.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 文章信息实体、文章&&标签关联表
 *
 * @author menghuan
 * @since 2019-12-28
 */
@Data
@TableName("tb_article")
public class SysArticle implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 标题
     */
    @NotNull
    private String title;

    /**
     * 封面图片
     */
    private String cover;

    /**
     * 作者
     */
    private String author;

    /**
     * 内容
     */
    private String content;

    /**
     * 内容-Markdown
     */
    @TableField("content_md")
    private String contentMd;

    /**
     * 分类
     */
    private String category;

    /**
     * 状态
     */
    private String state;

    /**
     * 发布时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("publish_time")
    private Date publishTime;

    /**
     * 上次修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("edit_time")
    private Date editTime;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("create_time")
    private Date createTime;

    @TableField(exist = false)
    private List<SysTag> tags;


    public SysArticle() {
    }

    public SysArticle(String category) {
        this.category = category;
    }

    public SysArticle(Long id, String category) {
        this.id = id;
        this.category = category;
    }

    public SysArticle(String title, String category) {
        this.title = title;
        this.category = category;
    }
}
