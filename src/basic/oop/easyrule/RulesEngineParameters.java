package basic.oop.easyrule;

/**
 * Parameters of a rules engine.
 *
 * <ul>
 *     <li>When parameters are used with a {@link DefaultRulesEngine}, they are applied on <strong>all registered rules</strong>.</li>
 *     <li>When parameters are used with a {@link InferenceRulesEngine}, they are applied on <strong>candidate rules in each iteration</strong>.</li>
 * </ul>
 *
 * @author Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 */
public class RulesEngineParameters {

    /**
     * Parameter to skip next applicable rules when a rule is applied.
     */
    private boolean skipOnFirstAppliedRule;

    /**
     * Parameter to skip next applicable rules when a rule has failed.
     */
    private boolean skipOnFirstFailedRule;

    /**
     * Create a new {@link RulesEngineParameters} with default values.
     */
    public RulesEngineParameters() {}

    public RulesEngineParameters(final boolean skipOnFirstAppliedRule, final boolean skipOnFirstFailedRule) {
        this.skipOnFirstAppliedRule = skipOnFirstAppliedRule;
        this.skipOnFirstFailedRule = skipOnFirstFailedRule;
    }

    public boolean isSkipOnFirstAppliedRule() {
        return skipOnFirstAppliedRule;
    }

    public void setSkipOnFirstAppliedRule(final boolean skipOnFirstAppliedRule) {
        this.skipOnFirstAppliedRule = skipOnFirstAppliedRule;
    }

    public RulesEngineParameters skipOnFirstAppliedRule(final boolean skipOnFirstAppliedRule) {
        setSkipOnFirstAppliedRule(skipOnFirstAppliedRule);
        return this;
    }

    public boolean isSkipOnFirstFailedRule() {
        return skipOnFirstFailedRule;
    }

    public void setSkipOnFirstFailedRule(final boolean skipOnFirstFailedRule) {
        this.skipOnFirstFailedRule = skipOnFirstFailedRule;
    }

    public RulesEngineParameters skipOnFirstFailedRule(final boolean skipOnFirstFailedRule) {
        setSkipOnFirstFailedRule(skipOnFirstFailedRule);
        return this;
    }

    @Override
    public String toString() {
        return "Engine parameters { " +
                "skipOnFirstAppliedRule = " + skipOnFirstAppliedRule +
                ", skipOnFirstFailedRule = " + skipOnFirstFailedRule +
                " }";
    }
}
