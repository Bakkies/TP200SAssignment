/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elton.library.services.impl;

import com.elton.library.domain.Member;
import com.elton.library.repository.MemberRepository;
import com.elton.library.services.MemberAgeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 101Lenboxs
 */
@Service
public class MemberAgeServiceImpl implements MemberAgeService{
    @Autowired
    private MemberRepository memberRepository;
    
    @Override
    public List<Member> getMemberAbove(int age){
        List<Member> members = new ArrayList<>();
        List<Member> allMembers = memberRepository.findAll();

        for (Member member : allMembers) {
            if (member.getAge() > age) {
                members.add(member);
            }
        }
        return members;
    }
}
