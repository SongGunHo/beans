package com.its.beans.service;

import com.its.beans.dto.MemberDTO;
import com.its.beans.entity.MemberEntity;
import com.its.beans.repostiory.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;


    public Long save(MemberDTO memberDTO) {
     return    memberRepository.save(MemberEntity.toSaveEntity(memberDTO)).getId();
    }

    public MemberDTO login(MemberDTO memberDTO) {
         Optional<MemberEntity> optionalMemberEntity = memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
             if(optionalMemberEntity.isPresent()){
                  MemberEntity memberEntity =optionalMemberEntity.get();
                  if(memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())){
                      return MemberDTO.toMemberDTO(memberEntity);
                  }else {
                      return null;
                  }
             }else {
                 return null;
             }
        }

    public List<MemberDTO> findAll() {
         List<MemberEntity> memberEntityList= memberRepository.findAll();
         List<MemberDTO> memberDTOList = new ArrayList<>();
         for(MemberEntity member : memberEntityList){
              memberDTOList.add(MemberDTO.toMemberDTO(member));
         }return memberDTOList;
    }

    public MemberDTO findById(Long id) {
         Optional<MemberEntity> optionalMemberEntity =memberRepository.findById(id);
         if(optionalMemberEntity.isPresent()){
              MemberEntity memberEntity =optionalMemberEntity.get();
              MemberDTO memberDTO = MemberDTO.toMemberDTO(memberEntity);
              return memberDTO;
         }else{
             return null;
         }
    }

    public void delate(Long id) {
        memberRepository.deleteById(id);
    }

    public void update(MemberDTO memberDTO) {
        memberRepository.update(MemberEntity.toMemberEntity(memberDTO));
    }

    public String email(String memberEmail) {
         Optional<MemberEntity> optionalMemberEntity =memberRepository.findByMemberEmail(memberEmail);
         if(optionalMemberEntity.isEmpty()){
            return "ok";
         }else{
             return "no";
         }
    }
}
