DELETE 
  FROM  USER_INFO
 WHERE  ID IN ('ywyi1992', 'ywyi1993');
  

INSERT INTO USER_INFO
VALUES ('ywyi1992', '윤원용', 'yunwonyong', 'M', '19921107', '1111111', '51221', '서울 강서구 가양동', '자바빌딩', 'ywyi1992', 'gmail.com', '01022222222')
     , ('ywyi1993', '윤원순', 'yunwonsoon', 'G', '19921107', '2222222', '51221', '서울 강서구 가양동', '자바빌딩', 'ywyi1993', 'gmail.com', '01022222222');

SELECT  ID  			
     ,  NAME 			
     ,  ENG_NAME		
     ,  GENDER		
     ,  BIRTH_DATE	
     ,  REAL_NUMBER	
     ,  ZIP_CODE		
     ,  ADDRESS		
     ,  ADDRESS_DTL	
     ,  EMAIL			
     ,  EMAIL_ADDRESS	
     ,  PHONE_NUMBER	
  FROM  USER_INFO