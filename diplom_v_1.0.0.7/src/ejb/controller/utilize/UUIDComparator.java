package ejb.controller.utilize;

public interface UUIDComparator<T> {
	T findByUuid(String uuid);
}
