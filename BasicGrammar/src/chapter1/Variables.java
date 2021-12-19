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
	                                              
	public short sMax = 0;                        
	public short sMin = 0;     
	
	public int iMax = Integer.MAX_VALUE; // 명사 + 명사 _ -> 언더스네이크 | 명사 + 명사 M -> 카멜문법 숙제4 
	public int iMin = Integer.MIN_VALUE;
}
