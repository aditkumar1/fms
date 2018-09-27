package com.expert_coder.alert.rule;

import com.expert_coder.entity.Alert;
import com.expert_coder.entity.Priority;
import com.expert_coder.entity.Reading;
import com.expert_coder.entity.Vehicle;
import com.expert_coder.repository.AlertRepository;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

@Rule(name = "Rule one", description = "Rule: engineRpm > readlineRpm, Priority: HIGH", priority = 1)
public class RuleOne {

    @Condition
    public boolean checkAlert(@Fact("vehicle") Vehicle vehicle, @Fact("reading") Reading reading) {
        return (reading.getEngineRpm() > vehicle.getReadlineRpm());
    }

    @Action
    public void generateAlert(@Fact("alertRepository") AlertRepository alertRepository, @Fact("vehicle") Vehicle vehicle, @Fact("reading") Reading reading) {
        alertRepository.save(new Alert("Engine RPM is greater than read line RPM.", Priority.HIGH, vehicle, reading.getTimestamp()));
    }

}
