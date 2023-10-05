package com.inf.infp1.singleton;

import com.inf.infp1.AppConfig;
import com.inf.infp1.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig=new AppConfig();
        //1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();
        //2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();
        Assertions.assertNotSame(memberService1, memberService2);

    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();
        Assertions.assertSame(instance1, instance2);

    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
    //    AppConfig appConfig=new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 =ac.getBean("memberService", MemberService.class);

        //2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 =ac.getBean("memberService", MemberService.class);
        Assertions.assertSame(memberService1, memberService2);

    }
}
