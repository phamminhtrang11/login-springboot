package com.example.logindemospringboot.Controller;

import com.example.logindemospringboot.ILogin.imp.LoginImp;

import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;

@RestController
public class LoginController {

    @PostMapping("/api/login")
    @ResponseBody
    public String checkUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        boolean loginFlag = LoginImp.getInstance().validUser(username, password);
        JSONObject jsonResponse = new JSONObject();
        if (loginFlag) {
            jsonResponse.put("success", true);
            jsonResponse.put("redirectURL", "/success");
        } else {
            jsonResponse.put("success", false);
        }
        return jsonResponse.toString();
    }
}
