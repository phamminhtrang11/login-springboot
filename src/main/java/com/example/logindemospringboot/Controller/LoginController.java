package com.example.logindemospringboot.Controller;

import com.example.logindemospringboot.ILogin.imp.LoginImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    private final LoginImp loginImp;
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public LoginController(LoginImp loginImp) {
        this.loginImp = loginImp;
    }

    @PostMapping("/api/login")
    @ResponseBody
    public String checkUser(@RequestBody LoginReq req) throws JsonProcessingException {
        // Validate
        // dung object mapper
        boolean loginFlag = loginImp.validUser(req.getUsername(), req.getPassword());
        Map<String, Object> rs = new HashMap<>();
        rs.put("success", loginFlag);
        rs.put("redirectURL", "/success");
        String jsonResponse = mapper.writeValueAsString(rs);

        return jsonResponse;
    }
}
