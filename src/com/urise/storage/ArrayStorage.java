package com.urise.storage;

import com.urise.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    @Override
    protected void insertByResume(Resume resume) {
        storage[size] = resume;
    }

    @Override
    protected void deleteByIndex(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
}


}
