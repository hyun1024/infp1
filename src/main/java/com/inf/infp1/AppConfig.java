package com.inf.infp1;

import com.inf.infp1.discount.DiscountPolicy;
import com.inf.infp1.discount.RateDiscountPolicy;
import com.inf.infp1.member.MemberRepository;
import com.inf.infp1.member.MemberService;
import com.inf.infp1.member.MemberServiceImpl;
import com.inf.infp1.member.MemoryMemberRepository;
import com.inf.infp1.order.OrderService;
import com.inf.infp1.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
