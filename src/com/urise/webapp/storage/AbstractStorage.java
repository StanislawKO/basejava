package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        Object index = existStorage(resume.getUuid());
        doUpdate(resume, index);
    }

    public void save(Resume resume) {
        Object index = notExistStorage(resume.getUuid());
        doSave(resume, index);
    }

    public Resume get(String uuid) {
        Object index = existStorage(uuid);
        return doGet(index);
    }

    public void delete(String uuid) {
        Object index = existStorage(uuid);
        doDelete(index);
    }

    protected abstract void doUpdate(Resume resume, Object index);

    protected abstract void doSave(Resume resume, Object index);

    protected abstract Resume doGet(Object index);

    protected abstract void doDelete(Object index);

    protected abstract Object getIndex(String uuid);

    protected abstract boolean isExist(Object index);

    private Object existStorage(String uuid) {
        Object index = getIndex(uuid);
        if (!isExist(index)) {
            throw new NotExistStorageException(uuid);
        }
        return index;
    }

    private Object notExistStorage(String uuid) {
        Object index = getIndex(uuid);
        if (isExist(index)) {
            throw new ExistStorageException(uuid);
        }
        return index;
    }
}
