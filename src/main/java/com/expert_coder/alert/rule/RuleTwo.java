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

@Rule(name = "Rule two", description = "Rule: Fuel volume is less than 10% of max fuel capacity. Priority: MEDIUM", priority = 2)
public class RuleTwo {

    @Condition
    public boolean checkAlert(@Fact("vehicle") Vehicle vehicle, @Fact("reading") Reading reading) {
        return (reading.getFuelVolume() < (0.10 * vehicle.getMaxFuelVolume()));
    }

    @Action
    public void generateAlert(@Fact("alertRepository") AlertRepository alertRepository, @Fact("vehicle") Vehicle vehicle, @Fact("reading") Reading reading) {
        alertRepository.save(new Alert("Fuel volume is less than 10% of max fuel capacity.", Priority.MEDIUM, vehicle, reading.getTimestamp()));
    }
}
