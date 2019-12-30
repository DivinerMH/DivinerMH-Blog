package cn.tycoding.system.entity.dto;

import cn.tycoding.system.entity.SysArticle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 用于封装Article表按时间归档的DTO
 *
 * @author menghuan
 * @since 2019-12-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArchivesWithArticle implements Serializable {

    /**
     * 日期
     */
    private String date;

    /**
     * List<文章信息实体、文章&&标签关联表>
     */
    private List<SysArticle> articles;
}
