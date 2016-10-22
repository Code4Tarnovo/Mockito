package code4tarnovo.mockito.core;

import java.util.List;

/**
 * Created by alroy on 22.10.16.
 */
public interface DestinationRepository {
    void register(Destination destination);

    List<Destination> getAll();

    List<Destination> getByName(String name);

    List<Destination> getByType(String type);

    List<Destination> getByRatingOrdered();
}
