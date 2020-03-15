import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0; //количество резюме в storage

    void clear() {
        Arrays.fill(storage, 0, size, null);
    }

    void save(Resume r) {
        Resume save = r;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid == uuid) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int i;
        for (i = 0; i < size; i++) {                //поиск удаляемого элемента
            if (storage[i].uuid == uuid) {
                break;
            }
        }
        for (int j = i; j < size - 1; j++) {        //сдвиг последующих элементов
            storage[j] = storage[j + 1];
        }
        size--;                                     //уменьшение количества резюме
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}
