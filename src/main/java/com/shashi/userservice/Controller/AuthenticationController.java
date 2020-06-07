package com.shashi.userservice.Controller;

import com.shashi.userservice.Model.AuthenticationRequest;
import com.shashi.userservice.Model.AuthenticationResponse;
import com.shashi.userservice.Model.User;
import com.shashi.userservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author akshaygupta01
 */
@RestController
public class AuthenticationController
{
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private UserResource userResource;

    @RequestMapping({ "/hello" })
    public String firstPage() {
        return "Hello World";
    }

    @RequestMapping(value = "/authenticate")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final User user = userResource.findUserByName(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(user);

        return new AuthenticationResponse(jwt);
    }

}
