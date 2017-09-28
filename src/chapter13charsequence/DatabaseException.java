package chapter13charsequence;

public class DatabaseException extends Exception {
    public DatabaseException(int transactionID,int queryID,String message) {
        super(String.format("(t%d q%d) %s",transactionID,queryID,message));
    }

    public static void main(String[] args) {
        try {
            throw new DatabaseException(3,7,"Write Failed");
        } catch (DatabaseException e) {
            System.out.println(e);//chapter13charsequence.DatabaseException: (t3 q7) Write Failed
        }
    }
}
