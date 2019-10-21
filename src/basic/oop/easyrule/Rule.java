package basic.oop.easyrule;

public interface Rule extends Comparable<Rule> {

	String DEFAULT_NAME = "rule";
	String DEFAULT_DESCRIPTION = "description";
	int DEFAULT_PRIORITY = Integer.MAX_VALUE - 1;

	String getName();

	String getDescription();

	int getPriority();

	boolean evaluate(Facts facts);

	void execute(Facts facts) throws Exception;

}
