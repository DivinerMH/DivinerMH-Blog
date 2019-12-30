package cn.tycoding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.tycoding.system.mapper")
public class DivinerMHApplication {

    public static void main(String[] args) {
        SpringApplication.run(DivinerMHApplication.class, args);
    }
}
