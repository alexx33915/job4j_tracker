package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализующий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(generateId());
        this.items[position++] = item;
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
    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }

    /**
     * Метод проверяет в цикле все элементы массива this.items,
     * сравнивая name (используя метод getName класса Item) с аргументом метода String key
     *
     * @return возвращает копию массива this.items без null элементов cо значением key
     */
    public Item[] findByName(String key) {
        Item[] itemsWithoutNull = new Item[position];
        int size = 0;
        for (int index = 0; index < position; index++) {
            Item name = items[index];
            if (name.getName().equals(key)) {
                itemsWithoutNull[size] = name;
                size++;
            }
        }
        return Arrays.copyOf(itemsWithoutNull, size);

    }

    /**
     * Метод проверяет в цикле все элементы массива this.items,
     * сравнивая name (используя метод getName класса Item) с аргументом метода String key
     *
     * @return возвращает копию массива this.items без null элементов cо значением key
     */
    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    /**
     * Метод возвращать index по id
     *
     * @return возвращать index
     */
    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод возвращать true если заявку поменяли на новую,
     * false если заявку не поменяли (нет такого id)
     * @return возвращать boolean
     */
    public boolean replace(String id, Item item) {
        int indexTemp = indexOf(id);
        if (indexTemp != -1) {
            item.setId(id);
            items[indexTemp] = item;
            return true;
        }
        return false;
    }

    /**
     * Метод возвращать true если заявку удалена
     * false если заявку не удалена (нет такого id)
     * @return возвращать boolean
     */
    public boolean delete(String id) {
        int index = indexOf(id);
        if(index != -1) {

            System.arraycopy(items, index + 1, items, index, position - index);

            position--;
            items[position ] = null;
            return true;
        }
        return false;
    }




}
