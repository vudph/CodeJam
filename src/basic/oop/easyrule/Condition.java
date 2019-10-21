package basic.oop.easyrule;

public interface Condition {
	
    boolean evaluate(Facts facts);

    Condition FALSE = new Condition() {
        @Override
        public boolean evaluate(Facts facts) {
            return false;
        }
    };
    
    Condition TRUE = new Condition() {
        @Override
        public boolean evaluate(Facts facts) {
            return true;
        }
    };
}