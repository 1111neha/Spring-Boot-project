package net.codejava.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.*;
import net.codejava.model.user;
import net.codejava.service.userService;

@Controller
public class userController {
	
	
	@Autowired
    private userService userService;

    // display list of employees
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listuser", userService.getAlluser());
        return "index";

}
    @GetMapping("/showNewuserForm")
    public String showNewuserForm(Model model)
    {
        // create model attribute to bind form data
        user user = new user();
        model.addAttribute("user", user);
        
        List<String> listslot = Arrays.asList("1", "2", "3","4","5","6","7","8","9","10");
        model.addAttribute("listslot", listslot);
         
        return "new_user";
    }
    
   
    
    @PostMapping("/saveuser")
    public String saveuser(@ModelAttribute("user")user user) {
    	userService.saveuser(user);
    	return "report";
    }
    @PostMapping("/saveuser1")
    public String saveuser1(@ModelAttribute("user")user user) {
    	userService.saveuser(user);
    	return "report2";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
     
     // get employee from the service
     user user = userService.getuserById(id);
     
     // set employee as a model attribute to pre-populate the form
     model.addAttribute("user", user);
     
     List<String> listslot = Arrays.asList("1", "2", "3","4","5","6","7","8","9","10");
     model.addAttribute("listslot", listslot);
     return "update_user";
    }
    @GetMapping("/deleteuser/{id}")
    public String deleteuser(@PathVariable (value = "id") long id) {
     
     // call delete employee method 
     this.userService.deleteuserById(id);
     return "report3";
    }
   
    @GetMapping("/adminpanel")
    public String adminpanel(Model model) {
        model.addAttribute("listuser", userService.getAlluser());
        return "index2";

    }
        
    
}

