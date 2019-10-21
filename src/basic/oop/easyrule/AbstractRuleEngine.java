package basic.oop.easyrule;

abstract class AbstractRuleEngine implements RulesEngine {

    RulesEngineParameters parameters;
    RulesEngineListener rulesEngineListener;

    AbstractRuleEngine() {
    	this(new RulesEngineParameters());
    }
    
    AbstractRuleEngine(final RulesEngineParameters parameters) {
        this.parameters = parameters;
    }
    
    public void registerRulesEngineListener(RulesEngineListener rulesEngineListener) {
        this.rulesEngineListener = rulesEngineListener;
    }
    
    public void unregisterRulesEngineListener(RulesEngineListener rulesEngineListener) {
        rulesEngineListener = null;
    }
}
