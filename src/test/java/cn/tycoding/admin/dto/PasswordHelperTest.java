package cn.tycoding.admin.dto;

import cn.tycoding.system.entity.SysUser;
import cn.tycoding.common.utils.PasswordHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author menghuan
 * @since 2019/10/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PasswordHelperTest {

    @Autowired
    private PasswordHelper passwordHelper;

    /**
     * 加密口令
     */
    @Test
    public void encryptPassword() {
        SysUser sysUser = new SysUser();
        sysUser.setId(1L);
        sysUser.setUsername("MengHuan");
        sysUser.setPassword("123456");
        sysUser.setSalt("536a51359841754df6bbab57d24d2128");
        passwordHelper.encryptPassword(sysUser);
        System.out.println(sysUser.getPassword()); // c0daa18ce0c74153ce060325cb4d1a04
    }
}
