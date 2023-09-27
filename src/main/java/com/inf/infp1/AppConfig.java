package com.inf.infp1;

import com.inf.infp1.discount.DiscountPolicy;
import com.inf.infp1.discount.RateDiscountPolicy;
import com.inf.infp1.member.MemberRepository;
import com.inf.infp1.member.MemberService;
import com.inf.infp1.member.MemberServiceImpl;
import com.inf.infp1.member.MemoryMemberRepository;
import com.inf.infp1.order.OrderService;
import com.inf.infp1.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
