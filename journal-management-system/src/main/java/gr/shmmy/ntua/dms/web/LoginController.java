package gr.shmmy.ntua.dms.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class LoginController implements AuthenticationSuccessHandler,
		AuthenticationFailureHandler {

	private final Logger log = Logger.getLogger(this.getClass());

	public LoginController() {
	}

	@RequestMapping(value ={ "/login", "/home" }, method = RequestMethod.GET)
	public ModelAndView prepareLoginPage() {
		log.info("Entering prepareLoginPage method");
		ModelAndView mav = new ModelAndView();

		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping(value ={ "/login", "/home" }, method = RequestMethod.POST)
	public ModelAndView preparePostRequestForLoginPage() {
		log.info("Entering prepareLoginPage method");
		ModelAndView mav = new ModelAndView();
		System.out.println("Mpika sto Post");
		mav.setViewName("login");
		return mav;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication auth) throws IOException,
			ServletException {
		msgPrinter("Authentication Successful");
        WebAuthenticationDetails details = (WebAuthenticationDetails) auth
                        .getDetails();
        log.info(details.getSessionId());
        System.out.println("Mpika sto authsucces");
        log.info("User Logged in from Remote Address : "
                        + details.getRemoteAddress());
        log.info(auth);
        log.info("Credentials : " + auth.getCredentials());
        log.info("Details : " + auth.getDetails());
        log.info("Name : " + auth.getName());
        log.info("Principal : " + auth.getPrincipal());
        log.info("isAuthenticated : " + auth.isAuthenticated());
        log.info("Authorities : " + auth.getAuthorities());
        log.info("*******************************************");
		//request.getRequestDispatcher("/docs").forward(request, response);
        
		response.sendRedirect("index");
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException arg2)
			throws IOException, ServletException {
		msgPrinter("Authentication Failed");
		log.info(request.getContextPath());
		
        System.out.println("Mpika sto autherror");

		
		request.setAttribute("loginErr", "Incorrect Username or Password!");
		request.getRequestDispatcher("/login").forward(request, response);
	}

	
	@RequestMapping(value = "/disclaimer")
	public String showDisclaimer() {
		return "disclaimer";
	}

	private void msgPrinter(String msg) {
		log.info("*******************************************");
		log.info("*** " + msg);
		log.info("*******************************************");
	}

}
