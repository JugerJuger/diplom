package web.controller.utilize;

import java.util.UUID;

import ejb.controller.utilize.UUIDComparator;

public class UUIDGenerator {
	
	private static String getUUID(UUIDComparator e) {
		String uuid = UUID.randomUUID().toString();
		if (e.findByUuid(uuid) != null)
			uuid = UUID.randomUUID().toString();
		return uuid;
	}
	
}
