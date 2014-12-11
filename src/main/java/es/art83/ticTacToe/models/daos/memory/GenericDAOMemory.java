package es.art83.ticTacToe.models.daos.memory;

import java.util.ArrayList;
import java.util.List;

import es.art83.ticTacToe.models.daos.GenericDAO;

public abstract class GenericDAOMemory<T, ID> implements GenericDAO<T, ID> {
    private List<T> entityList;

    public GenericDAOMemory() {
        this.entityList = new ArrayList<>();
    }

    public List<T> getEntityList() {
        return entityList;
    }
    
    @Override
    public void delete(T entity) {
        entityList.remove(entity);
    }

    @Override
    public List<T> findAll() {
        return null;
    }

}
