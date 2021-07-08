package com.cts.training.collateralwebportal.service;

import com.cts.training.collateralwebportal.feign.AuthClient;
import com.cts.training.collateralwebportal.model.LoginModel;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoginServiceimpl implements LoginService {

    @Autowired
    private AuthClient authClient;

    @Override
    public Boolean validate(String token) {
        return null;
    }

    @Override
    public String login(LoginModel model) {
        String token = authClient.login(model);
        log.error(token);
        return token;
    }
    
    
    /**
     * For Customer
     */
    @Override
	public String loginCustomer(LoginModel model) {
		String token = authClient.loginCustomer(model);
        log.error(token);
        return token;
	}

	@Override
	public ModelAndView checkStatus(HttpServletRequest request) {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("token")==null)
		{
			log.debug("User not logged in.Redirecting to login page");
			return new ModelAndView(new RedirectView("loginadmin"));
		}
		String token=request.getSession().getAttribute("token").toString();
		try {
			if(!authClient.validate(token)) {
				log.debug("Token is either invalid or expired. Redirecting to Login Page");
				return new ModelAndView(new RedirectView("session-expired"));
			}
		}
		catch (Exception e) {
			log.debug("Token is either invalid or expired. Redirecting to login page");
			return new ModelAndView(new RedirectView("session-expired"));
			// TODO: handle exception
		}
		return null;
	}
	
	/**
	 * For customer
	 */
	@Override
	public ModelAndView checkStatusCustomer(HttpServletRequest request) {
		if(request.getSession().getAttribute("token")==null)
		{
			log.debug("User not logged in.Redirecting to login page");
			return new ModelAndView(new RedirectView("logincustomer"));
		}
		String token=request.getSession().getAttribute("token").toString();
		try {
			if(!authClient.validateCustomer(token)) {
				log.debug("Token is either invalid or expired. Redirecting to Customer Login Page");
				return new ModelAndView(new RedirectView("session-expired"));
			}
		}
		catch (Exception e) {
			log.debug("Token is either invalid or expired. Redirecting to Customer login page");
			return new ModelAndView(new RedirectView("session-expired"));
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public int getCustId(String token) {
		return authClient.getCustId(token);
	}
	
	

	
    
}