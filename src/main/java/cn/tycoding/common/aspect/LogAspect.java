package cn.tycoding.common.aspect;

import cn.tycoding.common.exception.GlobalException;
import cn.tycoding.common.utils.HttpContextUtil;
import cn.tycoding.common.utils.IPUtil;
import cn.tycoding.system.entity.SysLog;
import cn.tycoding.system.entity.SysUser;
import cn.tycoding.system.service.LogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: LogAspect
 * @deprecated: 日志记录AOP实现 / 使用spring aop日志记录
 * @author: menghuan
 * @date: 2019-03-26
 */
@Aspect
@Component
public class LogAspect {

    @Autowired
    private LogService logService;

    //Pointcut表示式
    @Pointcut("@annotation(cn.tycoding.common.annotation.Log)")
    public void pointcut() {
    }

    /**
     *
     * @param proceedingJoinPoint   ProceedingJoinPoint获取实现类接口上的注解
     * @return
     * @throws JsonProcessingException
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws JsonProcessingException {
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw new GlobalException(throwable.getMessage());
        }
        // SecurityUtils 在 Shiro 中 ; 是一个抽象类。并且没有任何子类。在其中声明了一个静态属性，三个静态方法
        // getSubject()这个是 Shiro 中最核心的方法了，用来获取 Subject.
        // 使用shiro时，如果正常登陆（执行subject.login(token)成功）就能在全局通过SecurityUtils.getSubject().getPrincipal()获取用户信息。
        SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
        if (sysUser != null) {
            //当前开始时间，辅助于计算 记录时间“time”
            long beginTime = System.currentTimeMillis();
            //获取Request请求
            HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
            //设置IP地址
            String ip = IPUtil.getIpAddr(request);
            //记录时间（毫秒）
            long time = System.currentTimeMillis() - beginTime;
            //保存日志
            SysLog log = new SysLog();
            log.setIp(ip);
            log.setTime(time);
            //调用保存日志的方法
            logService.saveLog(proceedingJoinPoint, log);
            log.setUsername(sysUser.getUsername());
        }
        return result;
    }
}

/**
 * import org.aspectj.lang.reflect.SourceLocation;
 *
 * public interface JoinPoint {
 *    String toString();         //连接点所在位置的相关信息
 *    String toShortString();     //连接点所在位置的简短相关信息
 *    String toLongString();     //连接点所在位置的全部相关信息
 *    Object getThis();         //返回AOP代理对象，也就是com.sun.proxy.$Proxy18
 *    Object getTarget();       //返回目标对象，一般我们都需要它或者（也就是定义方法的接口或类，为什么会是接口呢？这主要是在目标对象本身是动态代理的情况下，例如Mapper。所以返回的是定义方法的对象如aoptest.daoimpl.GoodDaoImpl或com.b.base.BaseMapper<T, E, PK>）
 *    Object[] getArgs();       //返回被通知方法参数列表
 *    Signature getSignature();  //返回当前连接点签名  其getName()方法返回方法的FQN，如void aoptest.dao.GoodDao.delete()或com.b.base.BaseMapper.insert(T)(需要注意的是，很多时候我们定义了子类继承父类的时候，我们希望拿到基于子类的FQN，这直接可拿不到，要依赖于AopUtils.getTargetClass(point.getTarget())获取原始代理对象，下面会详细讲解)
 *    SourceLocation getSourceLocation();//返回连接点方法所在类文件中的位置
 *    String getKind();        //连接点类型
 *    StaticPart getStaticPart(); //返回连接点静态部分
 *   }
 *
 *  public interface ProceedingJoinPoint extends JoinPoint {
 *        public Object proceed() throws Throwable;
 *        public Object proceed(Object[] args) throws Throwable;
 *  }
 */
