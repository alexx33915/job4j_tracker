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
     * Метод возвращает  массив this.items
     *
     * @return возвращает  массив this.items
     */
    public List<Item> findAll() {
        return this.items;
    }

    /**
     * Метод проверяет в цикле все элементы массива this.items,
     * сравнивая name (используя метод getName класса Item) с аргументом метода String key
     *
     * @return возвращает копию массива this.items  cо значением key
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
     * сравнивая id  с аргументом метода String id
     *
     * @return возвращает Item по id
     */
    public Item findById(String id) {
        Item rsl = null;
        int indexTemp = indexOf(id);
        if (indexTemp != -1) {
           rsl = items.get(indexTemp);
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
        int indexTemp = indexOf(id);
        if (indexTemp != -1) {
            item.setId(id);
            items.set(indexTemp, item);
            return true;
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
        int indexTemp = indexOf(id);
        if (indexTemp != -1) {
            this.items.remove(indexTemp);
            return true;
        }
        return false;
    }


    /**
     *  Метод возвращает индекс элемента в ArrayList
     *  по id
     * @param id
     * @return  индекс , или -1 если не нашел id
     */
    private int indexOf(String id) {
        int rsl = -1;

        for (Item item : this.items) {
            if (item.getId().equals(id)) {
                rsl = this.items.indexOf(item);
                break;
            }
        }
        return rsl;
    }
}