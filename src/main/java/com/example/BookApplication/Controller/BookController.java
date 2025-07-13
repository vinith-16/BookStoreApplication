package com.example.BookApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.BookApplication.model.PathModel;
import com.example.BookApplication.model.UserPathModel;
import com.example.BookApplication.repository.BookRepository;
import com.example.BookApplication.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;





@Controller
public class BookController {

    @Autowired
    private BookRepository repo;

    @Autowired
    UserRepository rep;

    @GetMapping("/home")
    public String homepage() {
        return "pages/home";
    }
    

    @PostMapping("/submit")
    public String submit(PathModel book) {
        repo.save(book);
        return "pages/index";
    }

    @GetMapping("/view")
    public String viewBooks(HttpServletRequest request) {
        List<PathModel> books = repo.findAll();
        request.setAttribute("books", books);
        return "pages/view";
    }

 // Login Form Submission
    @GetMapping("/login")
    public String showLoginform(Model model) {
    	model.addAttribute("user",new UserPathModel());
    	return "pages/login";
    }
    
    @PostMapping("/login")
    public String login(@ModelAttribute("user") UserPathModel user, Model model) {
    	UserPathModel existingUser = rep.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    	if(existingUser != null) {
    		return "redirect:pages/view";
    	}
    	else {
    		model.addAttribute("error","Invalid email or password");
    		return "pages/login";
    	}
    }
    
    @GetMapping("/signup")
    public String showSignupForm(Model model) {
    	model.addAttribute("user",new UserPathModel());
    	return "pages/signup";
    }
    @PostMapping("/signup")
    public String signup(@ModelAttribute("user") UserPathModel user) {
    	rep.save(user);
    	return "redirect:pages/login";
    }
    
    @GetMapping("/index")
    public String index() {
        return "pages/index"; // assumes home.html is in src/main/resources/templates/
   }

    // Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:pages/home";
    }
    
    

    @GetMapping("/students/{bookNo}")
    public String deleteStudent(@PathVariable("bookNo") Long bookNo) {
        repo.deleteById(bookNo);
        return "redirect:pages/view";
    }
    
    @GetMapping("/edit/{bookNo}")
    public String showEditForm(@PathVariable("bookNo") Long bookNo, HttpServletRequest request) {
        PathModel book = repo.findById(bookNo).orElse(null);
        request.setAttribute("book", book);
        return "pages/editBook";  // JSP file name: editBook.jsp
    }

    @PostMapping("/update")
    public String updateBook(@ModelAttribute PathModel book) {
        repo.save(book);  // save() will update if bookNo already exists
        return "redirect:pages/view";
    }



}
