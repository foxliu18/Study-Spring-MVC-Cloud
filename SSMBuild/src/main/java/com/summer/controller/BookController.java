package com.summer.controller;

import com.summer.pojo.Books;
import com.summer.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;


    @RequestMapping("/allbook")
    public String list(Model model){
        List<Books> booksList = bookService.queryAllBooks();
        model.addAttribute("list", booksList);
        return "allBook";
    }

    @RequestMapping("/toAddBook")
    public String toAddBook(Model model){
        return "addBook";
    }
    @RequestMapping("/addBook")
    public String addBook(Books book){
        System.out.println("addBook=>"+book);
        bookService.add(book);
        return "redirect:/allbook";
    }

    @RequestMapping("/toUpdate")
    public String toUpdatePage(int id, Model model){
        Books book = bookService.queryBookByID(id);
        model.addAttribute("QBook", book);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Books book){
        System.out.println(book);
        bookService.updateBook(book);
        return "redirect:/allbook";
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(int id){
        bookService.deleteByID(id);
        return "redirect:/allbook";
    }

    @RequestMapping("/queryBook")
    public String queryBook(String queryName, Model model){
        Books books = bookService.queryBookByName(queryName);
        List<Books> list = new ArrayList<>();
        list.add(books);
        if(books == null){
            list = bookService.queryAllBooks();
            model.addAttribute("error", "未找到匹配结果");
        }
        model.addAttribute("list",list);
        return "allBook";
    }
}
