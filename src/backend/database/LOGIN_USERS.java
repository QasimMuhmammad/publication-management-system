package backend.database;

import backend.database.schema.Schema_Login;

public enum LOGIN_USERS implements Schema_Login
{
	REGISTERED_BUYER(1, LOGIN_USER_REGISTERED_BUYER),
	OPERATOR(2, LOGIN_USER_OPERATOR),
	SYSADMIN(3, LOGIN_USER_SYSADMIN);
		
	private final int id;
	private final String name;
	
	LOGIN_USERS(int id, String name)
	{
		this.id = id;
		this.name = name();
	}
	
	public int getId()
	{
		return id;
	}
	
	@Override
	public String toString()
	{
		return name;
	}
}
