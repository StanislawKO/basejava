package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> list = new ArrayList<>();

    @Override
    protected void doUpdate(Resume resume, int index) {
        list.set(index, resume);
    }

    @Override
    protected void doSave(Resume resume, int index) {
        list.set(index, resume);
    }

    @Override
    protected Resume doGet(int index) {
        return list.get(index);
    }

    @Override
    protected void doDelete(int index) {
        list.remove(index);
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Resume[] getAll() {
        return list.toArray(new Resume[list.size()]);
    }

    @Override
    public int size() {
        return list.size();
    }
}
