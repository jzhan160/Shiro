package com.demo.test.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Service;


@Service("annotationService")
public class AnnotationService {
    @RequiresRoles({"admin"})
    public void testShiroAnnotation(){
        System.out.println("testShiroAnnotation......");
        Session session = SecurityUtils.getSubject().getSession();
        System.out.println("session in service layer");
        System.out.println("=========================");
        System.out.println(session.getAttribute("key"));
    }
}
