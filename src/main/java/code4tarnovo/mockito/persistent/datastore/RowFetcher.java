package code4tarnovo.mockito.persistent.datastore;

import java.sql.ResultSet;

/**
 * Created by alroy on 22.10.16.
 */
public interface RowFetcher<T> {
    T fetchRow(ResultSet resultSet);
}
