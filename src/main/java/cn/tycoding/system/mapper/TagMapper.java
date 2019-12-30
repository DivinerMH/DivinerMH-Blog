package cn.tycoding.system.mapper;

import cn.tycoding.system.entity.SysTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author menghuan
 * @since 2019-12-28
 */
public interface TagMapper extends BaseMapper<SysTag> {

    List<SysTag> findByArticleId(@Param("id") long id);
}
