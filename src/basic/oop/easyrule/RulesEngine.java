package basic.oop.easyrule;

import java.util.Map;

public interface RulesEngine {

    void fire(Rules rules, Facts facts);

    /**
     * Check rules without firing them.
     * @return a map with the result of evaluation of each rule
     */
    Map<Rule, Boolean> check(Rules rules, Facts facts);
}
