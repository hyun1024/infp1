package com.inf.infp1;

import com.inf.infp1.member.Grade;
import com.inf.infp1.member.Member;
import com.inf.infp1.member.MemberService;
import com.inf.infp1.member.MemberServiceImpl;
import com.inf.infp1.order.Order;
import com.inf.infp1.order.OrderService;
import com.inf.infp1.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order=orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
