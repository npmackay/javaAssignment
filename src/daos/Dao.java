package daos;

import java.util.List;

//define generic type 
//T means type of the entity
//Functions to use on all Dao classes
public interface Dao <T, PK> {
    List<T> findAll();
    T findById(PK pk);
    //Type of the entitie insert
    void insert(T item);
    Boolean update(T item);
    Boolean delete(PK pk);
}
