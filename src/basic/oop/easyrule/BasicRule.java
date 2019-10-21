package basic.oop.easyrule;

public class BasicRule implements Rule {
    protected String name;
    protected String description;
    protected int priority;

    public BasicRule() {
        this(Rule.DEFAULT_NAME, Rule.DEFAULT_DESCRIPTION, Rule.DEFAULT_PRIORITY);
    }

    public BasicRule(final String name) {
        this(name, Rule.DEFAULT_DESCRIPTION, Rule.DEFAULT_PRIORITY);
    }

    public BasicRule(final String name, final String description) {
        this(name, description, Rule.DEFAULT_PRIORITY);
    }

    public BasicRule(final String name, final String description, final int priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
    }

    public boolean evaluate(Facts facts) {
        return false;
    }

    public void execute(Facts facts) throws Exception {
        // no op
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(final int priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        BasicRule basicRule = (BasicRule) o;

        if (priority != basicRule.priority)
            return false;
        if (!name.equals(basicRule.name))
            return false;
        return !(description != null ? !description.equals(basicRule.description) : basicRule.description != null);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + priority;
        return result;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(final Rule rule) {
        if (getPriority() < rule.getPriority()) {
            return -1;
        } else if (getPriority() > rule.getPriority()) {
            return 1;
        } else {
            return getName().compareTo(rule.getName());
        }
    }

}
