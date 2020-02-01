package com.pyf.elastic;

import com.pyf.elastic.bean.Book;
import com.pyf.elastic.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.util.List;

@SpringBootTest
class SpringbootElasticApplicationTests {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void saveIndex02(){
        Book book = new Book();
        book.setId(2);
        book.setBookName("遮天");
        book.setAuthor("辰东");
        boolean index = elasticsearchTemplate.createIndex("index",book);
    }

    @Test
    public void saveIndex(){
        Book book = new Book();
        book.setId(1);
        book.setBookName("斗破");
        book.setAuthor("土豆");
        bookRepository.index(book);
    }

    @Test
    public void searchIndex(){
//        Iterable<Book> all = bookRepository.findAll();
        List<Book> bookList = bookRepository.findbyBookName("破");

    }

}
