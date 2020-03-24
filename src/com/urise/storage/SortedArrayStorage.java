package com.urise.storage;

import com.urise.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertByResume(Resume resume) {

    }

    @Override
    protected void deleteByIndex(int index) {
        for (int i = index; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
