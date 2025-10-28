package app.dqproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dqproject.dto.UserLoginDTO;
import app.dqproject.models.User;
import app.dqproject.service.AuthService;

@RestController
@RequestMapping(path="api/v1/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<User> createUser(@RequestBody User user){
		return new ResponseEntity<User>(authService.createUser(user), HttpStatus.OK);
	}
	
	@PostMapping("/token")
	public ResponseEntity<String> loggIn(@RequestBody UserLoginDTO userDTO){
		return new ResponseEntity<String>(authService.login(userDTO), HttpStatus.OK);
	}
}
