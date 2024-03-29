package br.com.robytech.SystemManagentRestaurant.config.Security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.robytech.SystemManagentRestaurant.models.User;
import br.com.robytech.SystemManagentRestaurant.repository.UserRepository;

public class AuthTokenFilter extends OncePerRequestFilter{

    private TokenService tokenService;

    private  UserRepository userRepository;

    public AuthTokenFilter(TokenService tokenService, UserRepository userRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
                String token = recoveryToken(request);
                boolean valid = tokenService.isTokenValid(token);
                if (valid) {
                    authenticateClient(token);
                }
                
                filterChain.doFilter(request,response);
    }

    private void authenticateClient(String token) {
        Long idUser = tokenService.getIdUser(token);
        User user = userRepository.findById(idUser).get();
        UsernamePasswordAuthenticationToken authetication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authetication);
    }

    private String recoveryToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (token == null || token.isEmpty() || token.startsWith("Bearer ")) {
            return null;
        }

        return token.substring(7, token.length());
    }
    
}
