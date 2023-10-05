package com.inf.infp1.singleton;

import com.inf.infp1.AppConfig;
import com.inf.infp1.member.MemberRepository;
import com.inf.infp1.member.MemberServiceImpl;
import com.inf.infp1.order.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();
        Assertions.assertSame(memberRepository, memberRepository1);
        Assertions.assertSame(memberRepository, memberRepository2);
    }
}
