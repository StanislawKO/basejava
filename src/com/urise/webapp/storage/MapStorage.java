package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Map;
import java.util.TreeMap;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> map = new TreeMap<>();

    @Override
    protected boolean isExist(Object index) {
        return map.containsKey((String) index);
    }

    @Override
    protected void doUpdate(Resume resume, Object uuid) {
        map.put((String) uuid, resume);
    }

    @Override
    protected void doSave(Resume resume, Object uuid) {
        map.put((String) uuid, resume);
    }

    @Override
    protected Resume doGet(Object uuid) {
        return map.get(uuid);
    }

    @Override
    protected void doDelete(Object uuid) {
        map.remove(uuid);
    }

    @Override
    protected String searchKey(String uuid) {
        return uuid;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Resume[] getAll() {
        return map.values().toArray(new Resume[map.size()]);
    }

    @Override
    public int size() {
        return map.size();
    }
}
