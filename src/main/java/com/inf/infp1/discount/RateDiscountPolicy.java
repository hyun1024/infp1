package com.inf.infp1.discount;

import com.inf.infp1.annotation.MainDiscountPolicy;
import com.inf.infp1.member.Grade;
import com.inf.infp1.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
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
