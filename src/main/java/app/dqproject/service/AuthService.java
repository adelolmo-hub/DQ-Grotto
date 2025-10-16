package app.dqproject.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
	
	private final String secretKey = "test";
	
	public String login(String email, String password) {
		User user = userRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException(1));
		
		if(!passwordEncoder.matches(password, user.getPassword())) {
			throw new RuntimeException("Contraseña incorrecta");
		}
		return Jwts.builder().setSubject(user.getId())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
				.signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), SignatureAlgorithm.HS256).compact();
	}
}
