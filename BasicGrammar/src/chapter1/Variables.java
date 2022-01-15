package chapter1;

public class Variables {                          
	public boolean bl; // false            
	public char c; // 2byte 유니코드 /u000-> ' '
	public byte b; // 0b  0000 0000         
	public short s; // 0s                   
	public int i; // ? null x 0i  
	public long l; // 0L        
	public float f ; // 0.0f           
	public double d; // 0.0            
	                                              
	public boolean bF = Boolean.FALSE;            
	public boolean bT = Boolean.TRUE;             
	                                              
	public byte bMax = Byte.MAX_VALUE; // wrap    
	public byte bMin = Byte.MIN_VALUE;            
	                                              
	public short sMax = Short.MAX_VALUE;                        
	public short sMin = Short.MIN_VALUE;     
	
	public int iMax = Integer.MAX_VALUE; // 명사 + 명사 _ -> 언더스네이크 | 명사 + 명사 M -> 카멜문법 숙제4 
	public int iMin = Integer.MIN_VALUE;
	
	public long lMax = Long.MAX_VALUE;
	public long lMin = Long.MIN_VALUE;
	
	public float fMax = Float.MAX_VALUE;
	public float fMin = Float.MIN_VALUE;
	
	public double dMax = Double.MAX_VALUE;
	public double dMin = Double.MIN_VALUE;
	
}
