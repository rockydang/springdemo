package com.rockydang.service.springdemo.web.interceptor;

import com.rockydang.service.springdemo.web.bean.BeanTest;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;

@Component(value = "userArgumentResolver")
public class UserArgumentResolver implements WebArgumentResolver {

    public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest
            webRequest) throws Exception {
        if (methodParameter.getParameterType().equals(BeanTest.class)) {
            return webRequest.getAttribute("123", RequestAttributes.SCOPE_SESSION);

        }
        return UNRESOLVED;
    }
}
