package com.sreviewonly.board.controller;

import com.sreviewonly.board.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/signup")
public class SignUpRestController {



    @GetMapping("/{email}")
    public ResponseEntity<Boolean> verifyEmail(@PathVariable("email") String email){

    }
}
