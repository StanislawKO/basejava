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

    public void update(Resume resume) {
        if (returnElement(resume.getUuid()) == -1) {
            System.out.println("Резюме " + resume + " нет в storage!");
        } else {
            storage[returnElement(resume.getUuid())] = resume;
        }
    }

    public void save(Resume resume) {
        if (size > storage.length) {
            System.out.println("Переполнение размера storage!");
        } else if (returnElement(resume.getUuid()) != -1) {
            System.out.println("Резюме " + resume + " есть в storage!");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    public Resume get(String uuid) {
        if (returnElement(uuid) == -1) {
            System.out.println("Резюме нет в storage!");
            return null;
        } else {
            return storage[returnElement(uuid)];
        }
    }

    public void delete(String uuid) {
        if (returnElement(uuid) == -1) {
            System.out.println("Резюме нет в storage!");
        } else {
            storage[returnElement(uuid)] = storage[size - 1];
            storage[size - 1] = null;
            size--;
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

    private int returnElement(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
