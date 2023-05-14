package drools.service;

import drools.model.Case;
import drools.model.Employee;
import drools.model.Location;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EscalationService {

    @Autowired
    private KieContainer kContainer;

    public boolean canBeEscalated(Employee employee, Location location, Case myCase) {
        KieSession kieSession = kContainer.newKieSession();
        kieSession.setGlobal("myCase", myCase);
        kieSession.insert(employee);
        kieSession.insert(location);
        kieSession.insert(myCase);
        kieSession.fireAllRules();
        kieSession.dispose();
        System.out.println("Can case be escalated : " + myCase.isCanBeEscalated());
        return myCase.isCanBeEscalated();
    }
}
