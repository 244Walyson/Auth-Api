package com.waly.authAPI.services;



import com.waly.authAPI.dto.UserDTO;
import com.waly.authAPI.entities.Role;
import com.waly.authAPI.entities.User;
import com.waly.authAPI.projections.UserDetailsProjection;
import com.waly.authAPI.repositories.UserRepository;
import com.waly.authAPI.util.CustonUserUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private CustonUserUtil custonUserUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetailsProjection> result = repository.searchUserAndRolesByEmail(username);
        if(result.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }
        User user = new User();
        user.setEmail(username);
        user.setPassword(result.get(0).getPassword());
        for (UserDetailsProjection projection : result){
            user.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
        }
        return user;
    }

    protected User authenticade(){
       try{
           String username = custonUserUtil.getLoggedUsername();
           return repository.findByEmail(username).get();
       }
       catch (Exception e){
           throw new UsernameNotFoundException("User not found");
       }
    }

    public UserDTO getMe(){
        User user = authenticade();
        return new UserDTO(user);
    }

}
