/*
 * Copyright (C) Gustav Karlsson
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 * <p>http://www.apache.org/licenses/LICENSE-2.0
 *
 * <p>Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.kagkarlsson.scheduler.boot;

import com.github.kagkarlsson.scheduler.Clock;
import com.github.kagkarlsson.scheduler.ExecutePicked;
import com.github.kagkarlsson.scheduler.ExecutePickedFactory;
import com.github.kagkarlsson.scheduler.Executor;
import com.github.kagkarlsson.scheduler.HeartbeatConfig;
import com.github.kagkarlsson.scheduler.SchedulerClient;
import com.github.kagkarlsson.scheduler.SchedulerClientEventListener;
import com.github.kagkarlsson.scheduler.SchedulerState;
import com.github.kagkarlsson.scheduler.TaskRepository;
import com.github.kagkarlsson.scheduler.TaskResolver;
import com.github.kagkarlsson.scheduler.logging.ConfigurableLogger;
import com.github.kagkarlsson.scheduler.stats.StatsRegistry;
import com.github.kagkarlsson.scheduler.task.Execution;

public class ObservableExecutePickedFactory implements ExecutePickedFactory {

  public ExecutePicked create(
      Executor executor,
      TaskRepository taskRepository,
      SchedulerClientEventListener earlyExecutionListener,
      SchedulerClient schedulerClient,
      StatsRegistry statsRegistry,
      TaskResolver taskResolver,
      SchedulerState schedulerState,
      ConfigurableLogger failureLogger,
      Clock clock,
      HeartbeatConfig heartbeatConfig,
      Execution pickedExecution) {
    return new ObservableExecutePicked(
        executor,
        taskRepository,
        earlyExecutionListener,
        schedulerClient,
        statsRegistry,
        taskResolver,
        schedulerState,
        failureLogger,
        clock,
        heartbeatConfig,
        pickedExecution);
  }
}
