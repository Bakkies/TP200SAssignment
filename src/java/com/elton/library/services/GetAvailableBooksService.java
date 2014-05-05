/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elton.library.services;


import com.elton.library.domain.Book;
import java.util.List;

public interface GetAvailableBooksService {
    public List<Book> getAvailableBooks();
}
