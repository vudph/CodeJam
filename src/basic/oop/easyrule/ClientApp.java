package basic.oop.easyrule;

public class ClientApp {
	
	public static void main(String[] args) {
		// define facts
        Facts facts = new Facts();
        facts.put("rain", true);
        facts.put("time", "rush hour");
        
        Condition condition0 = new Condition() {
			@Override
			public boolean evaluate(Facts facts) {
				return facts.get("rain").equals(true);
			}
		};
		
		Action action0 = new Action() {
			@Override
			public void execute(Facts facts) throws Exception {
				System.out.println("It rains, take an umbrella!");
			}
		};
        
        Rule weatherRule = new RuleBuilder()
        						.name("weather rule")
        						.description("if it rains then take an umbrella")
        						.when(condition0)
        						.then(action0)
        						.build();
        
        Condition condition1 = new Condition() {
			@Override
			public boolean evaluate(Facts facts) {
				return facts.get("time").equals("rush hour");
			}
		};
		
		Action action1 = new Action() {
			@Override
			public void execute(Facts facts) throws Exception {
				System.out.println("It's rush hour, traffic is crowded!");
			}
		};
		
        Rule traffic = new RuleBuilder()
        					.name("traffic rule")
        					.description("if it's rush hours, traffic is red")
        					.when(condition1)
        					.then(action1)
        					.build();
        
        Rules rules = new Rules();
        rules.register(weatherRule);
        rules.register(traffic);

        // fire rules on known facts
        RulesEngineParameters param = new RulesEngineParameters(true, true);
        DefaultRulesEngine rulesEngine = new DefaultRulesEngine(param);
        RulesEngineListener rulesEngineListener = new RulesEngineListener() {
			
			@Override
			public void afterExecute(Rules rules, Facts facts) {
				System.out.println("DONE to fire rules");
			}
		};
        rulesEngine.registerRulesEngineListener(rulesEngineListener);
        
        rulesEngine.fire(rules, facts);
	}
}
