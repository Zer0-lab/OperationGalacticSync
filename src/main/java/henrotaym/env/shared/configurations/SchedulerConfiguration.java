package henrotaym.env.shared.configurations;

import henrotaym.env.shared. enums.ProfileName;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@Profile(ProfileName.SCHEDULER)
@EnableScheduling
public class SchedulerConfiguration {}
