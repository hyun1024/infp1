package com.inf.infp1.discount;

import com.inf.infp1.member.Grade;
import com.inf.infp1.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return price * discountPercent / 100;
        }
        return 0;
    }
}