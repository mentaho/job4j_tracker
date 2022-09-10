package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null && key.equals(items[index].getName())) {
                rsl[size] = items[index];
                size++;
            }
        }
        rsl = Arrays.copyOf(rsl, size);
        return rsl;
    }

    public Item[] findAll() {
        Item[] rsl = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            Item item = items[index];
            if (item != null) {
                rsl[size] = item;
                size++;
            }
        }
        rsl = Arrays.copyOf(rsl, size);
        return rsl;
    }

    public Boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items[index].setName(item.getName());
            return rsl;
        }
        return rsl;
    }

    public Boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items[index] = null;
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
            return rsl;
        }
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}