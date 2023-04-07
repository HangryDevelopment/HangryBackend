package hangrydevelopment.hangrybackend.controller;

import hangrydevelopment.hangrybackend.dto.UserAuthInfoDto;
// import hangrydevelopment.hangrybackend.services.AuthBuddy;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestBody;
import hangrydevelopment.hangrybackend.models.User;
import hangrydevelopment.hangrybackend.models.Role;
import hangrydevelopment.hangrybackend.dto.UserFetchDto;
import hangrydevelopment.hangrybackend.misc.FieldHelper;
import hangrydevelopment.hangrybackend.repository.UsersRepository;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/users", produces = "application/json")
public class UserController {
    private UsersRepository usersRepository;
    // private AuthBuddy authBuddy;

    // Using Google login, need to verify if email and password encoder is needed:
    // private PasswordEncoder passwordEncoder;
    //
    @GetMapping("")
    public List<UserFetchDto> fetchUsers() {
        // return usersRepository.fetchUserDTOs();
        List<User> users = usersRepository.findAll();
        List<UserFetchDto> userDTOs = new ArrayList<>();

        for (User user : users) {
            UserFetchDto userDTO = new UserFetchDto();
            userDTO.setId(user.getId());
            userDTO.setUserName(user.getUserName());
            userDTO.setPassword(user.getPassword());
            userDTOs.add(userDTO);
        }
        return userDTOs;
    }

    //
    @GetMapping("/{id}")
    public Optional<User> fetchUserById(@PathVariable long id) {
        Optional<User> optionalUser = usersRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User " + id + " not found");
        }
        return optionalUser;
    }

    @GetMapping("/username/{userName}")
    public ResponseEntity<User> getUserByUserName(@PathVariable String userName) {
        User user = usersRepository.findByUserName(userName);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User " + userName + " not found");
        }
        return ResponseEntity.ok(user);
    }

    // @GetMapping("/private")
    // @PreAuthorize("hasRole('ROLE_USER')")
    // public String getPrivateData() {
    //     return "This data is private and can only be accessed by authenticated users with the role ROLE_USER.";
    // }

    // @GetMapping("/admin")
    // @PreAuthorize("hasRole('ROLE_ADMIN')")
    // public String getAdminData() {
    //     return "This data is private and can only be accessed by authenticated users with the role ROLE_ADMIN.";
    // }

    // @GetMapping("/authinfo")
    // private UserAuthInfoDto getUserAuthInfo(@RequestHeader(value =
    // HttpHeaders.AUTHORIZATION, required = false) String authHeader) {
    // User loggedInUser = authBuddy.getUserFromAuthHeader(authHeader);

    // // use email to lookup the user's info
    // UserAuthInfoDto userDTO = new UserAuthInfoDto();
    // userDTO.setEmail(loggedInUser.getEmail());
    // userDTO.setRole(loggedInUser.getRole());
    // userDTO.setUserName(loggedInUser.getUserName());
    // userDTO.setAvatar_url(loggedInUser.getAvatar_url());
    // userDTO.setBackdrop_url(loggedInUser.getBackdrop_url());
    // userDTO.setId(loggedInUser.getId());
    // userDTO.setRegion(loggedInUser.getRegion());

    // return userDTO;
    // }
    //
    @GetMapping("/me")
    private Optional<User> fetchMe() {
        String userName = "Chase";
        User user = usersRepository.findByUserName(userName);
        return Optional.of(user);
    }

    // @GetMapping("/username/{userName}")
    // private Optional<User> fetchByUserName(@PathVariable String userName) {
    // User user = usersRepository.findByUserName(userName);
    // if (user.isEmpty()) {
    // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User " + id + " not
    // found");
    // }

    // return Optional.of(user);

    // }

    // @GetMapping("/email/{email}")
    // private User fetchByEmail(@PathVariable String email) {
    // User user = findUserByEmail(email);
    // if(user == null) {
    // // what to do if we don't find it
    // throw new RuntimeException("I don't know what I am doing");
    // }
    // return user;
    // }
    //
    @PostMapping("/create")
    public void createUser(@RequestBody User newUser) {
        // TODO: validate new user fields
        if (newUser.getUserName().contains("Chase")) {
            newUser.setRole(Role.ADMIN);
        } else {
            newUser.setRole(Role.USER);
        }
        // String plainTextPassword = newUser.getPassword();
        // String encryptedPassword = passwordEncoder.encode(plainTextPassword);
        // newUser.setPassword(encryptedPassword);
        newUser.setCreatedAt(LocalDate.now());
        usersRepository.save(newUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable long id) {
        Optional<User> optionalUser = usersRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User " + id + " not found");
        }
        usersRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@RequestBody User updatedUser, @PathVariable long id) {
        Optional<User> optionalUser = usersRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User " + id + " not found");
        }
        // get the user from the optional so we no longer have to deal with the optional
        User originalUser = optionalUser.get();

        // merge the changed data in updatedUser with originalUser
        BeanUtils.copyProperties(updatedUser, originalUser, FieldHelper.getNullPropertyNames(updatedUser));

        // originalUser now has the merged data (changes + original data)
        originalUser.setId(id);

        usersRepository.save(originalUser);
    }

    // @PutMapping("/{id}/updatePassword")
    // private void updatePassword(@PathVariable Long id, @RequestParam(required =
    // false) String oldPassword, @RequestParam String newPassword) {
    // Optional<User> optionalUser = usersRepository.findById(id);
    // if (optionalUser.isEmpty()) {
    // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User " + id + " not
    // found");
    // }
    //
    // User user = optionalUser.get();
    //
    // // compare old password with saved pw
    // if (!user.getPassword().equals(oldPassword)) {
    // throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "amscray");
    // }
    //
    // // validate new password
    // if (newPassword.length() < 3) {
    // throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "new pw length must
    // be at least 3 characters");
    // }
    //
    // user.setPassword(newPassword);
    // usersRepository.save(user);
    // }
}