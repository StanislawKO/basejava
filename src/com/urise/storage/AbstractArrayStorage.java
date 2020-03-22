package com.urise.storage;

import com.urise.model.Resume;

public abstract class AbstractArrayStorage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }
}
