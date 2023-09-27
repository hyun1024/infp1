package com.inf.infp1.order;

import com.inf.infp1.AppConfig;
import com.inf.infp1.member.Grade;
import com.inf.infp1.member.Member;
import com.inf.infp1.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA", 10000);
        Assertions.assertEquals(order.getDiscountPrice(), 1000);
    }
}
