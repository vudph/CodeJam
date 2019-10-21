package basic.oop.easyrule;

import java.util.ArrayList;
import java.util.List;

class DefaultRule extends BasicRule {

    private Condition condition = Condition.FALSE;
    private List<Action> actions = new ArrayList<>();

    DefaultRule(String name, String description, int priority, Condition condition, List<Action> actions) {
        super(name, description, priority);
        this.condition = condition;
        this.actions = actions;
    }

    @Override
    public boolean evaluate(Facts facts) {
        return condition.evaluate(facts);
    }

    @Override
    public void execute(Facts facts) throws Exception {
        for (Action action : actions) {
            action.execute(facts);
        }
    }

}
