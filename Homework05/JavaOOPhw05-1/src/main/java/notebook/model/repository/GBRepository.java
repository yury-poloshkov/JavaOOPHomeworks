package notebook.model.repository;

import notebook.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Репозиторий, для выполнения CreateReadUpdateDelete (CRUD) операций
 * @param <E> тип модели данных
 * @param <I> тип ID модели данных E
 */
public interface GBRepository<E, I> {
    E create(E e);
    List<E> findAll();
    User findById(I id);
    Optional<E> update(I id, E e);
    boolean delete(I id);
}
