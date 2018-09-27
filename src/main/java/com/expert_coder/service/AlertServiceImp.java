package com.expert_coder.service;


import com.expert_coder.Exception.VehicleNotFoundException;
import com.expert_coder.alert.rule.RuleFour;
import com.expert_coder.alert.rule.RuleOne;
import com.expert_coder.alert.rule.RuleThree;
import com.expert_coder.alert.rule.RuleTwo;
import com.expert_coder.entity.Reading;
import com.expert_coder.entity.Vehicle;
import com.expert_coder.repository.AlertRepository;
import com.expert_coder.repository.VehicleRepository;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RulesEngineParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlertServiceImp implements AlertService {

    @Autowired
    private AlertRepository alertRepository;

    @Autowired
    private VehicleRepository vRepository;

    @Override
    public void checkForAlert(Reading reading) {
        Optional<Vehicle> vehicleExist = vRepository.findByVin(reading.getVehicle().getVin());
        if (!vehicleExist.isPresent()) {
            throw new VehicleNotFoundException("Vehicle with VIN:#" + reading.getVehicle().getVin() + " not available.");
        }
        reading.setVehicle(vehicleExist.get());

        RulesEngineParameters parameters = new RulesEngineParameters();
        RulesEngine rulesEngine = new DefaultRulesEngine(parameters);
        Rules rules = new Rules();
        rules.register(new RuleOne());
        rules.register(new RuleTwo());
        rules.register(new RuleThree());
        rules.register(new RuleFour());

        Facts facts = new Facts();
        facts.put("vehicle", vehicleExist.get());
        facts.put("reading", reading);
        facts.put("alertRepository", alertRepository);
        rulesEngine.fire(rules, facts);
    }
}
