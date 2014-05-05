/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elton.library.services.impl;

import com.elton.library.domain.Member;
import com.elton.library.services.TotalGenderMembersService;
import com.elton.library.repository.MemberRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TotalGenderMembersServiceImpl implements TotalGenderMembersService{
    @Autowired
    private MemberRepository memberRepository;
    
    @Override
    public int numberGenderMembers(String gender){
        int members = 0;
        List<Member> allMembers = memberRepository.findAll();
        for (Member member : allMembers) {
            if (member.getGender().equals(gender)) {
                members++;
            }
        }
        return members;
    }
}
