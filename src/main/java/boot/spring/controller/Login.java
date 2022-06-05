package boot.spring.controller;

import javax.servlet.http.HttpSession;

import boot.spring.po.Staff;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import boot.spring.po.MSG;
import boot.spring.po.User;
import boot.spring.service.LoginService;



@Controller
public class Login {
	@Autowired
	LoginService loginservice;
	
	@RequestMapping("/loginvalidate")
	public String loginvalidate(@RequestParam("username") String username,@RequestParam("password") String pwd,HttpSession httpSession){
		if(username==null)
			return "login";
		LambdaQueryWrapper<Staff> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(Staff::getUsername,username);
		Staff emp = loginservice.getOne(queryWrapper);
		if(emp!=null&&pwd.equals(emp.getPassword()))
		{
			int uid=emp.getId();
			httpSession.setAttribute("uid", uid);
			return "chatroom";
		}else
			return "fail";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession httpSession){
		return "login";
	}
	
	@RequestMapping(value="/currentuser",method = RequestMethod.GET)
	@ResponseBody
	public User currentuser(HttpSession httpSession){
		int uid = (int)httpSession.getAttribute("uid");
		Staff staff = loginservice.getById(uid);
		String name=staff.getUsername();
		return new User(uid, name);
	}
  }
