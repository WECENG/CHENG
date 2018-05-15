package cn.gdou.controller.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"cn.gdou.services", "cn.gdou.DAO"},excludeFilters = {
        @ComponentScan.Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)
})
public class RootConfig {
}
