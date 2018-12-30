package ci.educhome.web.securities;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtTokenAuthenticationFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, 
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		/*response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin, Accept, X-Requested-With, Content-Type, "
				+ "Access-Control-Request-Method,"
				+ "Access-Control-Request-Headers,"
				+ "Authorization");
		response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin,"
				+ " Access-Control-Allow-Credentials, Authorization");*/

		String jwt=request.getHeader(SecurityConstants.HEADER_STRING);
		
		if(jwt==null || !jwt.startsWith(SecurityConstants.TOKEN_PREFIX)) {
			filterChain.doFilter(request, response);
			return;
		}
		
		String token=jwt.replace(SecurityConstants.TOKEN_PREFIX, "");
		
		try {
			Claims claims= Jwts.parser()
						   .setSigningKey(SecurityConstants.SECRET)
						   .parseClaimsJws(token)
						   .getBody();
			
			String login=claims.getSubject();
			
			if(login!=null) {
				
				@SuppressWarnings("unchecked")
				List<String> authorities = (List<String>) claims.get("authorities");
				
				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
						 login, null, authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		}catch (Exception e) {
			
			SecurityContextHolder.clearContext();
		}
		
		filterChain.doFilter(request, response);
	}

}
