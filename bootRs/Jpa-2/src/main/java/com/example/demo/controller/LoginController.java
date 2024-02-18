package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.vo.UserRole;

@RestController
public class LoginController  implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv=new ModelAndView("index");
		return mv;
	}
	
	@PostMapping("/login")
	public void dummy() {
		// 此登入會轉由 CustomUserDetailsService call back 接收登入帳號
		System.out.println("dummy");		
	}
	@GetMapping("/formlogin")
	public ModelAndView showLogin() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@PostMapping("/api/login")
	public ModelAndView login(@ModelAttribute User user) {
		User existingUser = userRepository.findByUsername(user.getUsername());
		System.out.println("/api/login:" + existingUser);
		if (existingUser == null) {
			return new ModelAndView("login");
		}
		if (bCryptPasswordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
			// 密碼驗證成功，這裡可以返回一個登入成功的訊息
			// 使用 SecurityContextHolder 取得當前的身份驗證
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

			// 檢查是否有用戶已經登入
			if (authentication != null && authentication.isAuthenticated()) {
				// 取得當前登入的用戶名稱
				String username = authentication.getName();
				System.out.println("before authentication.isAuthenticated :" + username);
				if (authentication != null && username.equals("anonymousUser")) {
					System.out.println("anonymousUser:" + authentication.getCredentials());
					String customUsername = existingUser.getUsername(); // 自訂的使用者名稱
					// Authentication newAuthentication = authenticationManager.authenticate(new
					// UsernamePasswordAuthenticationToken(customUsername,
					// existingUser.getPassword()));
					UserRole ur;
					switch (existingUser.getRole()) {
						case "ADMIN":
							ur = UserRole.ROLE_ADMIN;
							break;
						case "EMPLOYEE":
							ur = UserRole.ROLE_EMPLOYEE;
							break;
						default:
							ur = UserRole.GUEST;
							break;
					}
					Authentication newAuthentication = new UsernamePasswordAuthenticationToken(customUsername,
							existingUser.getPassword(), List.of(ur));
					SecurityContextHolder.getContext().setAuthentication(newAuthentication);
		authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("after authentication.isAuthenticated :" + authentication.getName());
	System.out.println("after authentication.isAuthenticated :" + authentication);
				}
			}
		}
		return new ModelAndView("login");
	}
	@GetMapping("/api/logout")
    public String logout() {
        // 在這裡執行登出相關的操作，例如清除Session等        
        // 返回登出成功後的頁面，或者導向到首頁或其他頁面
        return "redirect:/"; // 將用戶導向到首頁
    }
	
	 @GetMapping(value = { "/api/accountInfo" })
	   public ModelAndView accountInfo(Model model) {	 
	      UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      System.out.println(userDetails.getPassword());
	      System.out.println(userDetails.getUsername());
	      System.out.println(userDetails.isEnabled());	 
	      model.addAttribute("userDetails", userDetails);
	      ModelAndView mv=new ModelAndView("accountInfo");
	      return  mv;
	   }

	 @Override
		public void run(String... args) throws Exception {
			// TODO Auto-generated method stub
			User u1=new User("Mary",bCryptPasswordEncoder.encode("m123"),"ADMIN");
			userRepository.save(u1);
			User u2=new User("George",bCryptPasswordEncoder.encode("g123"),"EMPLOYEE");
			userRepository.save(u2);
		}
}

