package cn.tycoding.system.mapper;

import cn.tycoding.system.entity.SysCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author menghuan
 * @since 2019-12-28
 */
public interface CategoryMapper extends BaseMapper<SysCategory> {

    List<SysCategory> findCategoryByArticleId(@Param("id") long id);
}
