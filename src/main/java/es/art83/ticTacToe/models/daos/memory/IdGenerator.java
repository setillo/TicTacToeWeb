package es.art83.ticTacToe.models.daos.memory;

import java.util.HashMap;
import java.util.Map;

public class IdGenerator {
    private static IdGenerator idGenerator = new IdGenerator();

    private Map<String, Integer> idsMap;

    public IdGenerator() {
        this.idsMap = new HashMap<>();
    }

    public static IdGenerator getInstance() {
        return idGenerator;
    }

    public synchronized int generate(String key) {
        int id;
        if (idsMap.containsKey(key)) {
            id = idsMap.get(key) + 1;
            idsMap.put(key, id);
        } else {
            id = 1;
            idsMap.put(key, id);
        }
        return id;
    }

}
