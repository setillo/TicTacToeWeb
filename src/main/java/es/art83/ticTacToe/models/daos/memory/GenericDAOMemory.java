package es.art83.ticTacToe.models.daos.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.art83.ticTacToe.models.daos.GenericDAO;

public abstract class GenericDAOMemory<T, ID> implements GenericDAO<T, ID> {
    private Map<ID, T> bd = new HashMap<ID, T>();

    protected abstract ID getId(T entity);

    protected Map<ID, T> getBd() {
        return bd;
    }

    @Override
    public T read(ID id) {
        return this.bd.get(id);
    }

    @Override
    public void delete(T entity) {
        this.bd.remove(this.getId(entity));
    }

    @Override
    public void deleteByID(ID id) {
        this.bd.remove(id);
    }

    @Override
    public List<T> findAll() {
        return (List<T>) new ArrayList<T>(this.bd.values());
    }

}
