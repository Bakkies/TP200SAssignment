/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elton.library.services.impl;

import com.elton.library.domain.Member;
import com.elton.library.repository.MemberRepository;
import com.elton.library.services.TotalMembersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TotalMembersServiceImpl implements TotalMembersService{
    @Autowired
    private MemberRepository memberRepository;
    
    @Override
    public List<Member> getTotalMembers() {
        return memberRepository.findAll();
        }
}
