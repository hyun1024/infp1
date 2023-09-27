package com.inf.infp1.discount;

import com.inf.infp1.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
