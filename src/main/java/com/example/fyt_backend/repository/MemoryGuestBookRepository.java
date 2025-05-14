package com.example.fyt_backend.repository;

import com.example.fyt_backend.domain.GuestBook;

import java.util.HashMap;
import java.util.Map;

public class MemoryGuestBookRepository implements GuestBookRepository {

    private static final Map<Long, GuestBook> store = new HashMap<>();

    @Override
    public void save(GuestBook guestBook) {
        store.put(guestBook.getId(), guestBook);
    }

    @Override
    public GuestBook findById(Long id) {
        return store.get(id);
    }

    @Override
    public GuestBook findByOwnerId(Long ownerId) {
        return store.values().stream()
                .filter(guestBook -> guestBook.getOwnerId().equals(ownerId))
                .findFirst()
                .orElse(null);
    }

}
