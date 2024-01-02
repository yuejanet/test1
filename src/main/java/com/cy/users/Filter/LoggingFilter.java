package com.cy.users.Filter;

import org.springframework.boot.web.servlet.DispatcherType;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.EnumSet;

@Configuration
public class LoggingFilter extends GenericFilterBean {

    @Bean
    public FilterRegistrationBean<LoggingFilter> initFilter() {
        FilterRegistrationBean<LoggingFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new LoggingFilter());
        // *1* make sure you sett all dispatcher types if you want the filter to log upon
        // registrationBean.setDispatcherTypes(EnumSet.allOf(DispatcherType));

        // *2* this should put your filter above any other filter
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);

        return registrationBean;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        ContentCachingRequestWrapper wreq =
                new ContentCachingRequestWrapper(
                        (HttpServletRequest) request);

        ContentCachingResponseWrapper wres =
                new ContentCachingResponseWrapper(
                        (HttpServletResponse) response);

        try {

            chain.doFilter(wreq, wres);

            // makes sure that the input is read (e.g. in 404 it may not be)
            while (wreq.getInputStream().read() >= 0);

            System.out.printf("=== REQUEST%n%s%n=== end request%n",
                    new String(wreq.getContentAsByteArray()));

            System.out.printf("=== RESPONSE%n%s%n=== end response%n",
                    new String(wres.getContentAsByteArray()));

            // make sure call it after you read the content from the response
            wres.copyBodyToResponse();


        } catch (Throwable t) {
            throw t;
        }

    }
}
