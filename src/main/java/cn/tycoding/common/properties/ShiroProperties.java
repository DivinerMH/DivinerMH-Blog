package cn.tycoding.common.properties;

import lombok.Data;

/**
 * @author menghuan
 * @date 2019-09-20
 */
@Data
public class ShiroProperties {

    private long sessionTimeout;
    // Cookie 过期时间
    private int cookieTimeout;
    private String anonUrl;
    private String loginUrl;
    private String successUrl;
    private String logoutUrl;
}
