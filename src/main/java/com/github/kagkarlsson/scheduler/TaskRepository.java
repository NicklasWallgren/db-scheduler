package com.github.kagkarlsson.scheduler;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository {

	boolean createIfNotExists(Execution execution);
	List<Execution> getDue(LocalDateTime now);

	void remove(Execution execution);
	void reschedule(Execution execution, LocalDateTime nextExecutionTime);

	boolean pick(Execution e, LocalDateTime timePicked);

	List<Execution> getOldExecutions(LocalDateTime olderThan);

	void updateHeartbeat(Execution execution, LocalDateTime heartbeatTime);
}
