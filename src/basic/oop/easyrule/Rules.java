package basic.oop.easyrule;

import java.util.*;

public class Rules implements Iterable<Rule> {

    private Set<Rule> rules = new TreeSet<>();

    public Rules(Set<Rule> rules) {
        this.rules = new TreeSet<>(rules);
    }

    public Rules(Rule... rules ) {
        Collections.addAll(this.rules, rules);
    }

    public Rules(Object... rules ) {
        for (Object rule : rules) {
            this.register(rule);
        }
    }

    public void register(Object rule) {
        Objects.requireNonNull(rule);
        if (rule instanceof Rule) {
        	rules.add((Rule)rule);
        } else {
        	throw new RuntimeException("Invalid rule type");
        }
    }

    public void unregister(Object rule) {
        Objects.requireNonNull(rule);
        if (rule instanceof Rule) {
        	rules.remove((Rule)rule);
        } else {
        	throw new RuntimeException("Invalid rule type");
        }
    }

    public void unregister(final String ruleName){
        Objects.requireNonNull(ruleName);
        Rule rule = findRuleByName(ruleName);
        if(rule != null) {
            unregister(rule);
        }
    }

    public boolean isEmpty() {
        return rules.isEmpty();
    }

    public void clear() {
        rules.clear();
    }

    @Override
    public Iterator<Rule> iterator() {
        return rules.iterator();
    }

    private Rule findRuleByName(String ruleName){
        for(Rule rule : rules){
            if(rule.getName().equalsIgnoreCase(ruleName))
                return rule;
        }
        return null;
    }
}
