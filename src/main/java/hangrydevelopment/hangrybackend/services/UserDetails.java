// package hangrydevelopment.hangrybackend.services;

// import java.util.Collections;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import hangrydevelopment.hangrybackend.models.User;
// import hangrydevelopment.hangrybackend.repository.UsersRepository;

// @Service
// public class UserDetails implements UserDetailsService {

//     @Autowired
//     private UsersRepository userRepository;

//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         User user = userRepository.findByUserName(username);
//         if (user == null) {
//             throw new UsernameNotFoundException("User not found with username: " + username);
//         }
//         return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
//                 Collections.emptyList());
//     }
// }

