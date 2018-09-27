//package com.expert_coder.service;
//
//import org.springframework.lang.NonNull;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class TokenAuthenticationProviderService extends AbstractUserDetailsAuthenticationProvider {
//
//    @NonNull
//    UserAuthenticationService authenticationService;
//
//    @Override
//    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
//
//    }
//
//    @Override
//    protected UserDetails retrieveUser(String s, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
//        final Object token = authentication.findByToken();
//        return Optional
//                .ofNullable(token)
//                .map(String::valueOf)
//                .flatMap(authenticationService::findByToken)
//                .orElseThrow(() -> new UsernameNotFoundException("Cannot find user with authentication token=" + token));
//    }
//}
