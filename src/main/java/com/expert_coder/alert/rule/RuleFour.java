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

@Rule(name = "Rule Four", description = "Rule: EngineCoolant low or checkEngineLightOn. Priority: LOW", priority = 3)

public class RuleFour {
    @Condition
    public boolean checkAlaert(@Fact("vehicle") Vehicle vehicle, @Fact("reading") Reading reading) {
        return reading.isEngineCoolantLow() || reading.isCheckEngineLightOn();
    }

    @Action
    public void generateAlert(@Fact("alertRepository") AlertRepository alertRepository, @Fact("vehicle") Vehicle vehicle, @Fact("reading") Reading reading) {
        alertRepository.save(new Alert("EngineCoolant low or checkEngineLightOn.", Priority.LOW, vehicle, reading.getTimestamp()));
    }


}
