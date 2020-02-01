package com.pyf.elastic.repository;

import com.pyf.elastic.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
        public List<Book> findbyBookName(String bookName);
}
