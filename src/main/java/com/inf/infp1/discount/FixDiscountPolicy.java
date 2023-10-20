package com.inf.infp1.discount;

import com.inf.infp1.member.Grade;
import com.inf.infp1.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount=2000;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return discountFixAmount;
        }
        return 0;
    }
}
