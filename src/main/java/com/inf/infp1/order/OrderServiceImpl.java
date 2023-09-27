package com.inf.infp1.order;

import com.inf.infp1.discount.DiscountPolicy;
import com.inf.infp1.discount.FixDiscountPolicy;
import com.inf.infp1.member.Member;
import com.inf.infp1.member.MemberRepository;
import com.inf.infp1.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member=memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
