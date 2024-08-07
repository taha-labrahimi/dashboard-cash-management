package com.sorec.dashboardcashmanagement;

import com.sorec.dashboardcashmanagement.config.CORSFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class DashboardCashManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(DashboardCashManagementApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean crosFilterRegistration(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new CORSFilter());
        registrationBean.setName("CORS Filter");
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1);
        return registrationBean;
    }
    
}
