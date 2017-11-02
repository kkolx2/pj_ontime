//package com.skyoo.config;
//
//import java.io.IOException;
//import java.util.Arrays;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//
//import org.sitemesh.builder.SiteMeshFilterBuilder;
//import org.sitemesh.config.ConfigurableSiteMeshFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.JstlView;
//
//@Configuration
//public class SitemeshConfig {
//
//   /*
//    * sitemesh 적용하기 위한 필터링 처리.
//    */
//   @Bean
//   FilterRegistrationBean<ConfigurableSiteMeshFilter> siteMeshFilter() {
//      FilterRegistrationBean<ConfigurableSiteMeshFilter> filter = new FilterRegistrationBean<>();
//      
//      filter.setFilter(new ConfigurableSiteMeshFilter() {
//         
//         @Override
//         protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
//            
//            // 첫번째 인자로 url이 들어오면 두번째 인자의 경로를 적용하자.
//            builder.addDecoratorPaths("/board/*", "/WEB-INF/decorators/board.jsp");
//            builder.addDecoratorPaths("/dept/*", "/WEB-INF/decorators/default.jsp");
//            builder.addDecoratorPaths("/emp/*", "/WEB-INF/decorators/emp.jsp");
//            builder.addDecoratorPaths("/city/*", "/WEB-INF/decorators/city.jsp");
//            builder.addDecoratorPaths("/country/*", "/WEB-INF/decorators/country.jsp");
//            builder.addDecoratorPaths("/ontime/*", "/WEB-INF/decorators/ontime.jsp");
//            builder.addDecoratorPaths("/bootstrap/*", "/WEB-INF/decorators/bootstrap.jsp");
//         }
//      });
//      
//      filter.setUrlPatterns(Arrays.asList("/board/*", "/dept/*", "/emp/*", "/city/*", "/country/*", "/ontime/*","/bootstrap/*"));
//      
//      return filter;
//   }
//   
//   
//   /* 
//      jsp에서는 web.xml에 적용해서 필터링하면 되는뎅.
//       springboot에서는 web.xml이 없으니까..
//       이렇게 빈 등록해서 처리하도록 하자.
//   */
//   @Bean
//   FilterRegistrationBean<Filter> testFilter() {
//      FilterRegistrationBean<Filter> filter = new FilterRegistrationBean<>();
//
//      filter.setFilter(new Filter() {
//         
//         @Override
//         public void init(FilterConfig filterConfig) throws ServletException {
//            System.out.println("###################");
//            System.out.println("## My Filter init()");
//            System.out.println("###################");
//         }
//         
//         @Override
//         public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//               throws IOException, ServletException {
//            System.out.println("###");
//            System.out.println("### My Filter doFilter() start...");
//            System.out.println("###");
//            chain.doFilter(request, response);
//            System.out.println("###");
//            System.out.println("### My Filter doFilter() end...");
//            System.out.println("###");
//         }
//         
//         @Override
//         public void destroy() {
//            System.out.println("######################");
//            System.out.println("## My Filter destory()");
//            System.out.println("######################");
//         }
//      });
//      filter.setUrlPatterns(Arrays.asList("/dept/*", "/emp/*"));
//      
//      return filter;
//   }
//   
//}