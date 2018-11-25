package backend.database.schema;


public interface Schema_Login
{
	public static final String LOGIN_USER_REGISTERED_BUYER = "Registered Buyer";
	public static final String LOGIN_USER_OPERATOR = "Operator";
	public static final String LOGIN_USER_SYSADMIN = "Sysadmin";
	public static final String LOGIN_USER_FAIL = "Failure";

	
	public static final String LOGIN_TABLENAME = "login";
	public static final String LOGIN_USERNAME = "username";
	public static final String LOGIN_PASSWORD = "password";
	public static final String LOGIN_USERTYPE = "usertype";
	
	public static final String LOGIN_PATH 
	= "src/backend/database/data/login.txt";
}
