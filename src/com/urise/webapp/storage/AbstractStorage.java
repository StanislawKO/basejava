package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        Object searchKey = existKey(resume.getUuid());
        doUpdate(resume, searchKey);
    }

    public void save(Resume resume) {
        Object searchKey = notExistKey(resume.getUuid());
        doSave(resume, searchKey);
    }

    public Resume get(String uuid) {
        Object searchKey = existKey(uuid);
        return doGet(searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = existKey(uuid);
        doDelete(searchKey);
    }

    protected abstract void doUpdate(Resume resume, Object index);

    protected abstract void doSave(Resume resume, Object index);

    protected abstract Resume doGet(Object index);

    protected abstract void doDelete(Object index);

    protected abstract Object searchKey(String uuid);

    protected abstract boolean isExist(Object index);

    private Object existKey(String uuid) {
        Object searchKey = searchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object notExistKey(String uuid) {
        Object searchKey = searchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }
}
