package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class MapStorage extends AbstractStorage {
    @Override
    protected void doUpdate(Resume resume, int index) {

    }

    @Override
    protected void doSave(Resume resume, int index) {

    }

    @Override
    protected Resume doGet(int index) {
        return null;
    }

    @Override
    protected void doDelete(int index) {

    }

    @Override
    protected int getIndex(String uuid) {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return 0;
    }
}
