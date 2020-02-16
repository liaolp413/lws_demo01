package cn.com.java.lws;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 即时通讯启动类
 * */
@SpringBootApplication(scanBasePackages = "cn.com.java.lws.*")
@MapperScan("cn.com.java.lws.mapper")
public class LwsStart {
    public static void main(String[] args) {
        SpringApplication.run(LwsStart.class);
    }
}
