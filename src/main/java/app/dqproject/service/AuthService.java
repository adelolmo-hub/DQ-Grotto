package app.dqproject.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import app.dqproject.dto.UserLoginDTO;
import app.dqproject.exceptions.EntityNotFoundException;
import app.dqproject.models.User;
import app.dqproject.repository.IUserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class AuthService {
	
	@Autowired private IUserRepository userRepository;
	@Autowired private PasswordEncoder passwordEncoder;
	
	@Value("${jwt.secret}")
	private String secretKey;
	
	public String login(UserLoginDTO userDTO) {
		User user = userRepository.findByEmail(userDTO.getEmail()).orElseThrow(() -> new EntityNotFoundException(1));
		
		if(!passwordEncoder.matches(userDTO.getPassword(), user.getPassword())) {
			throw new RuntimeException("Contraseña incorrecta");
		}
		return Jwts.builder().setSubject(user.getId())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
				.signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), SignatureAlgorithm.HS256).compact();
	}
	
	public User createUser(User user) {
		if(userRepository.existsByEmail(user.getEmail())) {
			throw new IllegalStateException("User with email " + user.getEmail() + " already exists");
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
}
