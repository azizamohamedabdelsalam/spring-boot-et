package com.azizaabdelsalam.lil.sbet.landon.roomwebapp.controllers;


import com.azizaabdelsalam.lil.sbet.landon.roomwebapp.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/staffs")
public class StaffController {
    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }
@GetMapping
    public String getAllStaff(Model model){
        model.addAttribute("staffs", staffService.getAllStaff());
        return "staffs";
}


}
