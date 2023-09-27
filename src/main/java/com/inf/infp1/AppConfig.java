package com.inf.infp1;

import com.inf.infp1.discount.FixDiscountPolicy;
import com.inf.infp1.member.MemberService;
import com.inf.infp1.member.MemberServiceImpl;
import com.inf.infp1.member.MemoryMemberRepository;
import com.inf.infp1.order.OrderService;
import com.inf.infp1.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
