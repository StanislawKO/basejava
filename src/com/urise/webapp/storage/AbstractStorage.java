package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        int index = existStorage(resume.getUuid());
        doUpdate(resume, index);
    }

    public void save(Resume resume) {
        int index = notExistStorage(resume.getUuid());
        doSave(resume, index);
    }

    public Resume get(String uuid) {
        int index = existStorage(uuid);
        return doGet(index);
    }

    public void delete(String uuid) {
        int index = existStorage(uuid);
        doDelete(index);
    }

    protected abstract void doUpdate(Resume resume, int index);

    protected abstract void doSave(Resume resume, int index);

    protected abstract Resume doGet(int index);

    protected abstract void doDelete(int index);

    protected abstract int getIndex(String uuid);

    private int existStorage(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return index;
    }

    private int notExistStorage(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            throw new ExistStorageException(uuid);
        }
        return index;
    }
}
