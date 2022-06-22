package com.dust.hello;

import com.dust.hello.discount.DiscountPolicy;
import com.dust.hello.discount.RateDiscountPolicy;
import com.dust.hello.member.MemberService;
import com.dust.hello.member.MemberServiceImpl;
import com.dust.hello.member.MemoryMemberRepository;
import com.dust.hello.order.OrderService;
import com.dust.hello.order.OrderServiceImpl;


public class AppConfig {

    private MemoryMemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    public MemberService memberService() {
        return new MemberServiceImpl(MemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(MemberRepository(), discountPolicy());
    }
}
