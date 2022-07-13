package com.mxgraph.online;

import javax.servlet.ServletContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SecretFacade 
{
    private SecretFacade() { }

    public static String getSecret(String key, ServletContext servletContext) 
    {
		try
		{
			return readInputStream(servletContext
							.getResourceAsStream("/WEB-INF/" + key))
							.replaceAll("\n", "");
		}
		catch (Exception e2)
		{
			throw new RuntimeException("Reading secret " + key + " failed.");
		}
    }

	/**
	 * Reads an input stream and returns the result as a String
	 * @param stream the input stream to read
	 * @return a String representation of the input stream
	 * @throws IOException
	 */
	public static String readInputStream(InputStream stream) throws IOException
	{
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(stream));
		StringBuffer result = new StringBuffer();
		String tmp = reader.readLine();

		while (tmp != null)
		{
			result.append(tmp + "\n");
			tmp = reader.readLine();
		}

		reader.close();

		return result.toString();
	}

}
