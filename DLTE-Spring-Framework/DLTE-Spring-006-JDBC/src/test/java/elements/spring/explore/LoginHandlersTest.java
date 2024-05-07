package elements.spring.explore;

import elements.spring.explore.auth.MyBankOfficials;
import elements.spring.explore.auth.MyBankOfficialsService;
import elements.spring.explore.auth.OfficialsFailureHandler;
import elements.spring.explore.auth.OfficialsSuccessHandler;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.servlet.ServletException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class LoginHandlersTest {
    @Mock
    private MyBankOfficialsService myBankOfficialsService;

    @InjectMocks
    private OfficialsSuccessHandler successHandler;

    @InjectMocks
    private OfficialsFailureHandler failureHandler;

    @Test
    public void testAuthenticationFailureAttempts() throws IOException, ServletException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        AuthenticationException exception = new LockedException("Max Attempts reached account is suspended");

        String username = "testUser";
        request.setParameter("username", username);
        MyBankOfficials myBankOfficials = new MyBankOfficials();
        myBankOfficials.setUsername(username);
        myBankOfficials.setStatus(1); // Assuming status allows authentication
        myBankOfficials.setAttempts(2); // Assuming maximum attempts are 3
        when(myBankOfficialsService.findByUsername(username)).thenReturn(myBankOfficials);

        failureHandler.onAuthenticationFailure(request, response, exception);

        assertEquals("/web/?error=3 Attempts are taken", response.getRedirectedUrl());
    }

    @Test
    public void testAuthenticationFailureSuspend() throws IOException, ServletException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        AuthenticationException exception = new LockedException("Max Attempts reached account is suspended");

        String username = "testUser";
        request.setParameter("username", username);
        MyBankOfficials myBankOfficials = new MyBankOfficials();
        myBankOfficials.setUsername(username);
        myBankOfficials.setStatus(1); // Assuming status allows authentication
        myBankOfficials.setAttempts(3); // Assuming maximum attempts are 3
        when(myBankOfficialsService.findByUsername(username)).thenReturn(myBankOfficials);

        failureHandler.onAuthenticationFailure(request, response, exception);

        assertEquals("/web/?error=Max Attempts reached account is suspended", response.getRedirectedUrl());
    }

    @Test
    public void testAuthenticationFailureAttemptsExceeded() throws IOException, ServletException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        AuthenticationException exception = new BadCredentialsException("Invalid credentials");

        String username = "testUser";
        MyBankOfficials myBankOfficials = new MyBankOfficials();
        myBankOfficials.setUsername(username);
        myBankOfficials.setStatus(1); // Assuming status allows authentication
        myBankOfficials.setAttempts(3); // Assuming maximum attempts are 3
        when(myBankOfficialsService.findByUsername(username)).thenReturn(myBankOfficials);

        failureHandler.onAuthenticationFailure(request, response, exception);

        assertEquals("/web/?error=User not exists",response.getRedirectedUrl());
    }

    @Test
    public void testAuthenticationFailureUserNotExists() throws IOException, ServletException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        AuthenticationException exception = new UsernameNotFoundException("User not exists");

        String username = "nonExistingUser";
        when(myBankOfficialsService.findByUsername(username)).thenReturn(null);

        failureHandler.onAuthenticationFailure(request, response, exception);

        assertEquals("/web/?error=User not exists", response.getRedirectedUrl());
    }


    // success handler test
    @Test
    public void testMaxAttemptsReached() throws IOException, ServletException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        Authentication authentication = mock(Authentication.class);
        MyBankOfficials myBankOfficials = new MyBankOfficials();
        myBankOfficials.setStatus(0); // Assuming status indicates maximum attempts reached
        when(authentication.getPrincipal()).thenReturn(myBankOfficials);

        successHandler.onAuthenticationSuccess(request, response, authentication);

        assertEquals("/web/?error=contact admin", response.getRedirectedUrl());
    }

    @Test
    public void testSuccessHandler() throws IOException, ServletException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        Authentication authentication = mock(Authentication.class);
        MyBankOfficials myBankOfficials = new MyBankOfficials();
        myBankOfficials.setStatus(1); // Assuming status allows authentication
        when(authentication.getPrincipal()).thenReturn(myBankOfficials);

        successHandler.onAuthenticationSuccess(request, response, authentication);

        assertEquals("/web/dash", response.getRedirectedUrl());
//        HttpServletRequest request = mock(HttpServletRequest.class);
//        HttpServletResponse response = mock(HttpServletResponse.class);
//
//        MyBankOfficials dummyUser = new MyBankOfficials(); // Create a dummy authenticated user
//        dummyUser.setFullName("John Doe");
//        dummyUser.setUsername("john.doe");
//        dummyUser.setPassword("password123");
//        dummyUser.setContact(1234567890);
//        dummyUser.setRole("ROLE_USER");
//        dummyUser.setAttempts(1);
//        dummyUser.setStatus(1);// Set initial attempts as needed
//        //when(myBankOfficialsService.findByUsername(Mockito.anyString())).thenReturn(dummyUser);
//
//        Authentication authentication = mock(Authentication.class);
//        when(authentication.getPrincipal()).thenReturn(dummyUser);
//        successHandler.onAuthenticationSuccess(request, response, authentication);
//
//        // Assert the redirection URL
//        Mockito.verify(successHandler).setDefaultTargetUrl("/web/dash");
    }

}
