DELETE 
  FROM  LOGIN_INFO
 WHERE  ID IN ('ywyi1992', 'ywyi1993')
   AND  PASSWORD = '1234';
  
INSERT INTO login_info(ID, PASSWORD)
VALUES ('ywyi1992', '1234');

INSERT INTO login_info(ID, PASSWORD)
VALUES ('ywyi1993', '1234');

/*
* 회원 목록 조회 쿼리
*/
SELECT  ID
     ,  PASSWORD
  FROM  LOGIN_INFO;

/*
* 로그인 쿼리
*/
SELECT  ID
     ,  PASSWORD 
  FROM  LOGIN_INFO
 WHERE  ID = 'ywyi1992'
   AND  PASSWORD = '1234';
   
   
SELECT  ID
     ,  PASSWORD 
  FROM  LOGIN_INFO
 WHERE  ID = 'ywyi1992'
   AND  PASSWORD = '123';
