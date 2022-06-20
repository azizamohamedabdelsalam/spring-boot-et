package com.azizaabdelsalam.lil.sbet.landon.roomwebapp.service;

import com.azizaabdelsalam.lil.sbet.landon.roomwebapp.models.Position;
import com.azizaabdelsalam.lil.sbet.landon.roomwebapp.models.StaffMember;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StaffService {

    private static final List<StaffMember> staffs = new ArrayList<>();
    static{
        staffs.add(new StaffMember(UUID.randomUUID().toString(),"John","Doe", Position.CONCIERGE.toString()));
        staffs.add(new StaffMember(UUID.randomUUID().toString(),"Aziza","Mazen", Position.FRONT_DESK.toString()));
        staffs.add(new StaffMember(UUID.randomUUID().toString(),"Mohamed","Mohamed", Position.SECURITY.toString()));
        staffs.add(new StaffMember(UUID.randomUUID().toString(),"Ahmed","Mahmoud", Position.HOUSEKEEPING.toString()));
    }

    public List<StaffMember> getAllStaff() { return staffs; }
}
