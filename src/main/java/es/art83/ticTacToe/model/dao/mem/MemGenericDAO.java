package es.art83.ticTacToe.model.dao.mem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.art83.ticTacToe.model.dao.GenericDAO;



public abstract class MemGenericDAO<T, ID> implements GenericDAO<T, ID> {
    private Map<ID, T> bd = new HashMap<ID, T>();

    protected abstract ID getId(T entity);

    @Override
    public void create(T entity) {
        this.bd.put(this.getId(entity), entity);
    }

    @Override
    public T read(ID id) {
        return this.bd.get(id);
    }

    @Override
    public void update(T entity) {
        if (this.bd.containsValue(entity))
            this.bd.put(this.getId(entity), entity);
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
