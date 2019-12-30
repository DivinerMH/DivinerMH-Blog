package cn.tycoding.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author menghuan
 * @since 2019-12-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_comment")
public class SysComment implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 父级ID，给哪个留言进行回复
     */
    @TableField("p_id")
    private Long pId;

    /**
     * 子级ID，给哪个留言下的回复进行评论
     */
    @TableField("c_id")
    private Long cId;

    /**
     * 文章标题
     */
    @TableField("article_title")
    private String articleTitle;

    /**
     * 文章ID
     */
    @TableField("article_id")
    private Long articleId;

    /**
     * 昵称
     */
    @NotNull
    private String name;

    /**
     * 给谁留言
     */
    @TableField("c_name")
    private String cName;

    /**
     * 留言时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;

    /**
     * 留言内容
     */
    private String content;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 网址
     */
    private String url;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 设备
     */
    private String device;

    /**
     * 地址
     */
    private String address;

    /**
     * 评论分类：0 Article, 1 Archives, 2 About
     * 分类：0:默认，文章详情页，1:友链页，2:关于页
     */
    private Integer sort;
}
