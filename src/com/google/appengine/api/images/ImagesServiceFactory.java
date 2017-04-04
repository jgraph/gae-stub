package com.google.appengine.api.images;

public class ImagesServiceFactory
{
	public static ImagesService getImagesService()
	{
		return new ImagesService();
	}
	
	public static Image makeImage(byte[] imageData)
	{
		return new Image();
	}
	
	public static Transform makeCrop(double leftX, double topY, double rightX, double bottomY)
	{
		return new Transform();
	}
}
