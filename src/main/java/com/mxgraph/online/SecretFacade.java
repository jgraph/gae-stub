package com.mxgraph.online;

import javax.servlet.ServletContext;

public class SecretFacade 
{
    private SecretFacade() { }

    public static String getSecret(String key, ServletContext servletContext) 
    {
		try
		{
			return Utils.readInputStream(servletContext
							.getResourceAsStream("/WEB-INF/" + key))
							.replaceAll("\n", "");
		}
		catch (Exception e2)
		{
			throw new RuntimeException("Reading secret " + key + " failed.");
		}
    }
}
