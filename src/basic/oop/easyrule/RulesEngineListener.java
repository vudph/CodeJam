package basic.oop.easyrule;

public interface RulesEngineListener {
	
	void afterExecute(Rules rules, Facts facts);
	
}