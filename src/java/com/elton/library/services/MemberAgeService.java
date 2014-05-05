/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elton.library.services;

import com.elton.library.domain.Member;
import java.util.List;


public interface MemberAgeService {
    public List<Member> getMemberAbove(int i);
}
