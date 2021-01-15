package domain.common;

import java.util.Objects;
import java.util.UUID;

public class AggregateId {

    private final String id;

    public AggregateId() {
        this.id = UUID.randomUUID().toString();
    }

    public AggregateId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public boolean equals(final AggregateId aggregateId) {
        return this.id.equals(aggregateId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AggregateId that = (AggregateId) o;
        return Objects.equals(id, that.id);
    }
}
