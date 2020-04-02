package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class ListStorage extends AbstractStorage {

    @Override
    protected void implementUpdate(Resume resume, int index) {

    }

    @Override
    protected void implementSave(Resume resume, int index) {

    }

    @Override
    protected Resume implementGet(int index) {
        return null;
    }

    @Override
    protected void implementDelete(int index) {

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
