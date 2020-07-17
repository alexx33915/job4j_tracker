package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    List<Item> items = new ArrayList<>();


    /**
     * Метод реализующий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    /**
     * Метод возвращает копию массива this.items без null элементов
     *
     * @return возвращает копию массива this.items без null элементов
     */
    public List<Item> findAll() {
        return this.items;  //Arrays.copyOf(items, position);
    }

    /**
     * Метод проверяет в цикле все элементы массива this.items,
     * сравнивая name (используя метод getName класса Item) с аргументом метода String key
     *
     * @return возвращает копию массива this.items без null элементов cо значением key
     */
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item item : this.items) {
            if (item.getName().equals(key))
                rsl.add(item);
        }
        return rsl;
    }

    /**
     * Метод проверяет в цикле все элементы массива this.items,
     * сравнивая name (используя метод getName класса Item) с аргументом метода String key
     *
     * @return возвращает копию массива this.items без null элементов cо значением key
     */
    public Item findById(String id) {
        Item rsl = null;
        for (Item item : this.items)
            if (item.getId().equals(id)) {
                rsl = item;
                break;
            }
        return rsl;
    }

    /**
     * Метод возвращать true если заявку поменяли на новую,
     * false если заявку не поменяли (нет такого id)
     *
     * @return возвращать boolean
     */
    public boolean replace(String id, Item item) {
        for (Item rsl : this.items) {
            if (rsl.getId().equals(id)) {
                item.setId(id);
                int index = items.indexOf(rsl);
                items.set(index, item);
                return true;
            }
        }
        return false;
    }

    /**
     * Метод возвращать true если заявку удалена
     * false если заявку не удалена (нет такого id)
     *
     * @return возвращать boolean
     */
    public boolean delete(String id) {
        for (Item item : this.items) {
            if (item.getId().equals(id)) {
                this.items.remove(item);
                return true;
            }
        }
        return false;
    }
}