package app.dqproject.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUtils {

	public static String getCurrentUserId() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth == null && auth.getName() == null) {
			throw new IllegalStateException("There is no authenticated user");
		}
		return auth.getName();
	}
}
