package edu.handong.analysis;

public class CustomizedGenerics<T> {
	
	private T data;
    public void setData (T newValue)
    {
        data = newValue;
    }

    public T getData ()
    {
        return data;
    }

}
