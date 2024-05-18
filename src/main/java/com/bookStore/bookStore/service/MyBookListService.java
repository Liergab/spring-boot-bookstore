package com.bookStore.bookStore.service;

import com.bookStore.bookStore.entity.MyBookList;
import com.bookStore.bookStore.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService {
    @Autowired
    private MyBookRepository MyBook;

    public void saveMyBook(MyBookList book ){
        MyBook.save(book);
    }

    public List<MyBookList> getAllMyBooks(){
        return MyBook.findAll();
    }

    public void deleteMyList(int id){
        MyBook.deleteById(id);
    }

}
