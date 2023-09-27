package com.inf.infp1.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
