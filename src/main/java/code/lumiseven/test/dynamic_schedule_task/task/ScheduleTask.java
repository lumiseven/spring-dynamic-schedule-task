package code.lumiseven.test.dynamic_schedule_task.task;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Slf4j
@Component
@PropertySource("classpath:/task-config.ini")
public class ScheduleTask implements SchedulingConfigurer {

    @Value("${printTime.cron}")
    private String cron;

    @Value("${printTime.period}")
    private Long timer;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                log.info("Current time: {}", LocalDateTime.now());
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
//                CronTrigger ct = new CronTrigger(cron);
//                Date nextExecutionTime = ct.nextExecutionTime(triggerContext);
//                return nextExecutionTime;

                PeriodicTrigger pt = new PeriodicTrigger(timer);
                Date nextExecutionTime = pt.nextExecutionTime(triggerContext);
                return nextExecutionTime;
            }
        });
    }
}
