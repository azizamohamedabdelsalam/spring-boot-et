package com.azizaabdelsalam.lil.sbet.landon.roomwebapp.data;

import com.azizaabdelsalam.lil.sbet.landon.roomwebapp.models.Room;
import com.azizaabdelsalam.lil.sbet.landon.roomwebapp.models.StaffMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<StaffMember,String> {
}
