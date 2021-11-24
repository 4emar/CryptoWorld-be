package com.crypto.demo.web;



import com.crypto.demo.model.Dto.JwtResponseDto;
import com.crypto.demo.model.Dto.LoginDto;
import com.crypto.demo.model.Dto.RegisterDto;
import com.crypto.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public HttpStatus registerUser(@RequestBody RegisterDto registerDto){
        this.userService.signUpUser(registerDto);
        return HttpStatus.OK;

    }

    @PostMapping("/signIn")
    public ResponseEntity<JwtResponseDto> loginUser(@RequestBody LoginDto loginDto){
        return ResponseEntity.ok()
                .body(this.userService.signInUser(loginDto));
    }
}
