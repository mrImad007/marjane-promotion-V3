package com.example.sb.resource;

import com.example.sb.model.dto.AdminDto;
import com.example.sb.model.dto.AdminRequest;
import com.example.sb.service.Impl.AdminManagerApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "api/v3/admins")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminResource {
    private final AdminManagerApplication adminService;
    @Autowired
    public AdminResource(AdminManagerApplication adminService) {
        this.adminService = adminService;
    }
    @GetMapping
    public List <AdminDto> getAdmins() {
    return  adminService.getAdmins();
}
    @PostMapping
    public void  registerNewAdmin(@RequestBody AdminRequest admin){
        adminService.addNewAdmin(admin.toModel());
    }
    @GetMapping(path = "{adminemail}")
    public AdminDto getAdminByEmail(@PathVariable("adminemail") String email) {
        return  adminService.getAdminByEmail(email);
    }
    @DeleteMapping(path = "{adminId}")
    public void deletAdmin(@PathVariable("adminId") Long adminid){
        adminService.deleteAdmin(adminid);
    }
    @PutMapping(path = "{adminId}")
    public void updateAdmin(
            @PathVariable("adminId") Long adminId,
            @RequestParam (required = false) String email,
            @RequestParam (required = false) String password){
                adminService.updateAdmin(adminId,email,password);
    }

    @PostMapping("/auth")
    public AdminDto auth(@RequestBody HashMap<String, String> request){
        System.out.println(request.get("email")+" and "+request.get("password"));
        return adminService.auth(request.get("email"),request.get("password"));
    }

}
