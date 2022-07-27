package com.its.beans.repostiory;

import com.its.beans.dto.MemberDTO;
import com.its.beans.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository  extends JpaRepository<MemberEntity,Long> {

  Optional<MemberEntity> findByMemberEmail(String memberEmail);

  MemberEntity update(MemberEntity toMemberEntity);


}
