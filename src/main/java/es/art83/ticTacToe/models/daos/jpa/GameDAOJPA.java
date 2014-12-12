package es.art83.ticTacToe.models.daos.jpa;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import es.art83.ticTacToe.models.daos.GameDAO;
import es.art83.ticTacToe.models.entities.GameEntity;
import es.art83.ticTacToe.models.entities.PlayerEntity;

public class GameDAOJPA extends TransactionGenericDAOJPA<GameEntity, Integer> implements GameDAO {

    public GameDAOJPA() {
        super(GameEntity.class);
    }

    @Override
    public List<String> findPlayerGameNames(PlayerEntity player) {
        // Se crea un criterio de consulta
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<String> query = builder.createQuery(String.class);
        // Se establece la clausula FROM
        Root<GameEntity> root = query.from(GameEntity.class);
        // Se establece la clausula SELECT
        query.select(root.get("name")); // criteriaQuery.multiselect(root.get(atr))
        // Se configura el predicado
        Predicate predicate = builder.equal(root.get("player").as(PlayerEntity.class), player);
        // Se establece el WHERE
        query.where(predicate);
        // Se crea el resultado
        TypedQuery<String> tq = em.createQuery(query);
        tq.setFirstResult(0);
        tq.setMaxResults(0); // Se buscan todos
        return tq.getResultList();
    }

    @Override
    public GameEntity findGame(PlayerEntity player, String gameName) {
        // Se crea un criterio de consulta
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<GameEntity> query = builder.createQuery(GameEntity.class);
        // Se establece la clausula FROM
        Root<GameEntity> root = query.from(GameEntity.class);
        // Se establece la clausula SELECT
        query.select(root); // criteriaQuery.multiselect(root.get(atr))
        // Se configura el predicado
        Predicate predicate1 = builder.equal(root.get("player").as(PlayerEntity.class), player);
        Predicate predicate2 = builder.equal(root.get("name").as(String.class), gameName);
        Predicate predicate = builder.and(predicate1, predicate2);
        // Se establece el WHERE
        query.where(predicate);
        // Se crea el resultado
        TypedQuery<GameEntity> tq = em.createQuery(query);
        return tq.getSingleResult();
    }

}
