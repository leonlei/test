package com.proxy.dao;

import com.proxy.dao.imp.BookImpl;

/**
 * Created by Administrator.
 * User: Leon
 * 2016/2/25
 */
public class TestProxy {
    public static void main(String[] args) {
        BookProxy proxy = new BookProxy();
        Book book = (Book)proxy.bind(new BookImpl());
        book.addBook();

    }
}
