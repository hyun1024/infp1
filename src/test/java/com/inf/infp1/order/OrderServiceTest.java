package com.inf.infp1.order;

import com.inf.infp1.member.Grade;
import com.inf.infp1.member.Member;
import com.inf.infp1.member.MemberService;
import com.inf.infp1.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService= new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA", 10000);
        Assertions.assertEquals(order.getDiscountPrice(), 1000);
    }
}
