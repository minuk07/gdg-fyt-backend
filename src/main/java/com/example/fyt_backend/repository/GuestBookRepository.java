package com.example.fyt_backend.repository;

import com.example.fyt_backend.domain.GuestBook;

public interface GuestBookRepository {

    void save(GuestBook guestBook);

    GuestBook findById(Long id);

    GuestBook findByOwnerId(Long ownerId);
}
