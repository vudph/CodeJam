package basic.oop.easyrule;

import java.util.HashMap;
import java.util.Map;

public final class DefaultRulesEngine extends AbstractRuleEngine {

	public DefaultRulesEngine(final RulesEngineParameters parameters) {
        super(parameters);
    }
	
	@Override
	public void fire(Rules rules, Facts facts) {
		doFire(rules, facts);
		triggerListenersAfterRules(rules, facts);
	}

	void doFire(Rules rules, Facts facts) {
		for (Rule rule : rules) {
			if (rule.evaluate(facts)) {
				try {
					rule.execute(facts);
					if (parameters.isSkipOnFirstAppliedRule()) {
						System.out.println("Next rules will be skipped since parameter skipOnFirstAppliedRule is set");
						break;
					}
				} catch (Exception exception) {
					if (parameters.isSkipOnFirstFailedRule()) {
						System.out.println("Next rules will be skipped since parameter skipOnFirstFailedRule is set");
                        break;
                    }
				}
			}
		}
	}

	@Override
	public Map<Rule, Boolean> check(Rules rules, Facts facts) {
		Map<Rule, Boolean> result = doCheck(rules, facts);
		return result;
	}

	private Map<Rule, Boolean> doCheck(Rules rules, Facts facts) {
		Map<Rule, Boolean> result = new HashMap<>();
		for (Rule rule : rules) {
			result.put(rule, rule.evaluate(facts));
		}
		return result;
	}
	
	private void triggerListenersAfterRules(Rules rules, Facts facts) {
		rulesEngineListener.afterExecute(rules, facts);
    }
}
