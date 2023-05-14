package drools.app;

import drools.model.Case;
import drools.model.Employee;
import drools.model.Location;
import drools.service.EscalationConfiguration;
import drools.service.EscalationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(EscalationConfiguration.class);
        EscalationService escalationService = (EscalationService) context.getBean(EscalationService.class);
        Employee employee = new Employee("Manager");
        Location location = new Location("SJC31");
        Case myCase = new Case();
        myCase.setNoOfDays(10);

        escalationService.canBeEscalated(employee, location, myCase);
    }

}
