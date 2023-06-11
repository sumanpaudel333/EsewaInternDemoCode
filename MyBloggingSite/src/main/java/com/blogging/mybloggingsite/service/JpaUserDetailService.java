package com.blogging.mybloggingsite.service;

import com.blogging.mybloggingsite.model.Author;
import com.blogging.mybloggingsite.repo.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JpaUserDetailService implements UserDetailsService {
    private final AuthorRepository authorRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Author author =authorRepository.findByUserName(username).orElseThrow();
        return User.withUsername(author.getUserName()).password(author.getPassword()).authorities("Admin").build();
    }
}
