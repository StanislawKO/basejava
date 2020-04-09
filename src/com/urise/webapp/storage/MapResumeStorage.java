package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage {
    Map<String, Resume> map = new HashMap<>();

    @Override
    protected void doUpdate(Resume resume, Object r) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected void doSave(Resume resume, Object r) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume doGet(Object resume) {
        return (Resume) resume;
    }

    @Override
    protected void doDelete(Object resume) {
        map.remove(((Resume) resume).getUuid());
    }

    @Override
    protected Resume getSearchKey(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected boolean isExist(Object resume) {
        return resume != null;
    }

    @Override
    protected List<Resume> doCopyAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public int size() {
        return map.size();
    }
}
