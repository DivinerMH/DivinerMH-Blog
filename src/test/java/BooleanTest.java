import org.junit.Test;


/**
 * @Author:menghuan
 * @Date:2020/5/14 13:19
 */
public class BooleanTest {

    @Test
    public void BooleanTest(){
        boolean bool = false;
        if (bool) {
            //代码不会打问印出答Hello World
            System.out.println("Hello World1-1");
        }
        if (bool = true) { //这里bool 已经是true
            //代码会打印出Hello World
            System.out.println("Hello World-2");
        }
        if (bool == true) { //这里bool与true比较的结果为：flase （这种说法测试结果：错误）
            //代码会打印出Hello World
            System.out.println("Hello World-3");
        }
        if (bool != true) { //这里bool与true比较的结果为：flase （这种说法测试结果：错误）
            //代码不会打印出Hello World
            System.out.println("Hello World-4");
        }

    }


}
