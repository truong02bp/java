package com.mypham.ultis;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUlti 
{
	private String value;
	public HttpUlti(String value)
	{
		this.value = value;
	}
	
	public <T> T toModel(Class<T> tClass)
	{
		try {
			return new ObjectMapper().readValue(value, tClass);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static HttpUlti of(BufferedReader br)
	{
		StringBuilder sb = new StringBuilder();
		String line="";
		try {
			while ((line = br.readLine())!=null)
			{
				sb.append(line);
			}
		} catch (IOException e) {
			return null;
		}
		return new HttpUlti(sb.toString());
	}
}
