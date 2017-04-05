package com.google.appengine.api.utils;

public class SystemProperty
{
	public static SystemProperty applicationVersion = new SystemProperty()
	{
		public String get()
		{
			return "1.0.0";
		}
	};
	
	public static SystemProperty environment = new SystemProperty()
	{
		public String get()
		{
			// Not GAE environment
			return "Non";
		}
	};
	
	public String get()
	{
		return "";
	}
	
	public String key()
	{
		return "";
	}
}
