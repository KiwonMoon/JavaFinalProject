package edu.handong.analysis;

public class CustomizedGenerics<T> {
	
	public T data;
	//public int size = 0;
	private Object[] element;
	private int index;
	//CustomizedGenerics<String> = new ArryaList<>();
	
    public void setData (T newValue)
    {
        //data = newValue;
    	element = new Object[0];
    	element[index++] = newValue;
    }

    public T getData ()
    {
        //return data;
    	return (T) element[index];
    }
    
    public int index() {
    	return index;
    }

}
