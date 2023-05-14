package drools.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Case {

    private int noOfDays;

    private boolean canBeEscalated;
}
