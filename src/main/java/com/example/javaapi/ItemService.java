package com.example.javaapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final List<Item> items = new ArrayList<>();
    private Long currentId = 1L;

    public Item addItem(Item item) {
        item.setId(currentId++);
        items.add(item);
        return item;
    }

    public Optional<Item> getItemById(Long id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }
}
