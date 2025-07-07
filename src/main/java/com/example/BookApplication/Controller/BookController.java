package com.example.BookApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.BookApplication.model.UserPathModel;
import com.example.BookApplication.model.PathModel;
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
        return "home";
    }
    
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/submitLogin")
    public String submitLogin(UserPathModel login) {
        rep.save(login);
        return "addBook";
    }

    @GetMapping("/addBook")
    public String addBook() {
        return "addBook";
    }

    @PostMapping("/submit")
    public String submit(PathModel book) {
        repo.save(book);
        return "index";
    }

    @GetMapping("/view")
    public String viewBooks(HttpServletRequest request) {
        List<PathModel> books = repo.findAll();
        request.setAttribute("books", books);
        return "view";
    }

 // Login Form Submission
    @PostMapping("/login")
   public String loginSubmit(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("Yoga".equals(username) && "Yoga@123".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            return "redirect:/home";
        } else {
            request.setAttribute("error", "Invalid username or password");
            return "login";
        }
    }
    
    @GetMapping("/index")
    public String index() {
        return "index"; // assumes home.html is in src/main/resources/templates/
    }

    // Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
    
    

    @GetMapping("/students/{bookNo}")
    public String deleteStudent(@PathVariable("bookNo") Long bookNo) {
        repo.deleteById(bookNo);
        return "redirect:/view";
    }
    
    @GetMapping("/edit/{bookNo}")
    public String showEditForm(@PathVariable("bookNo") Long bookNo, HttpServletRequest request) {
        PathModel book = repo.findById(bookNo).orElse(null);
        request.setAttribute("book", book);
        return "editBook";  // JSP file name: editBook.jsp
    }

    @PostMapping("/update")
    public String updateBook(@ModelAttribute PathModel book) {
        repo.save(book);  // save() will update if bookNo already exists
        return "redirect:/view";
    }



}