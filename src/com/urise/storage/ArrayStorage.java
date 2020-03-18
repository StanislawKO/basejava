package com.urise.storage;

import com.urise.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;                                   //количество резюме в storage

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        if (size > 10000) {
            System.out.println("Переполнение размера storage!");
        }

        boolean isResume = true;
        for (int i = 0; i < size; i++) {
            if (storage[i] == r) {
                isResume = false;
            }
        }

        if (isResume) {
            storage[size] = r;
            size++;
        } else {
            System.out.println("Резюме есть в storage!");
        }
    }

    public Resume get(String uuid) {
        Resume resume = null;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid() == uuid) {
                resume = storage[i];
            } else {
                System.out.println("Резюме нет в storage!");
            }
        }
        return resume;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {                        //поиск удаляемого элемента
            if (storage[i].getUuid() == uuid) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;                                     //уменьшение количества резюме
                return;
            } else {
                System.out.println("Резюме нет в storage!");
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    public void update(Resume resume) {

    }
}
