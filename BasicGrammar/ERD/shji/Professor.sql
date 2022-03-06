USE mydb;

INSERT INTO login_info (ID, Password)
VALUES ('shji', '0000'),
('test', '1111'),
('hong', '2222');

SELECT *
  FROM login_info;

INSERT INTO user_info (
ID,				NAME,				ENG_NAME,		GENDER,
BIRTH_DATE,		REAL_NUMBER,		ZIP_CODE,		ADDRESS,
ADDRESS_DTL,	EMAIL,				EMAIL_ADDRESS,	PHONE_NUMBER)
VALUES 
('shji', 		'지서향',				'Ji Seohyang',  0,
20010723,		'0107231111111',  	11111,	    	'경기도 안산시',
'000동 0000호',	'ksk076', 		  	'naver.com',	'01012345678'),
('test', 		'테스트',				'Test', 		1,
20220302,		'2203021111111',  	22222,	    	'서울시',
'222동 2002호',	'test', 		  	'daum.net',		'01022222222'),
('hong', 		'홍길동',				'Hong gildong',  0,
20000302,		'0003021111111',  	22222,	    	'광명시',
'302동 1702호',	'hong0302', 		'gmail.com',	'01034567890');

SELECT *
  FROM user_info;

INSERT INTO professor (
PROFESSOR_CODE,		ID, 	SALARY,		ENT_DATE,
RET_DATE,			USE_YN 
)
VALUES 
(1,			'shji',		2000000,	20220227,
99991231,	'Y'),
(2,			'test',		3000000,	20220302,
99991231,	'Y'),
(3,			'hong',		5000000,	20220302,
99991231,		'Y');
 
 SELECT *
  FROM professor;
  
INSERT INTO major (
MAJOR_CODE,		PROFESSOR_HEAD_USER_CODE,	MAJOR_NAME,		MAJOR_PHONE_NUMBER,
USE_YN
)
VALUES 
(001,		1,		'컴퓨터공학과',		'02-1234-5678',
'Y'),
(002,		3,		'경영학과',		'02-3456-7890',
'Y'),
(003,		2,		'수학과',			'02-0987-6543',
'Y');

SELECT *
  FROM major;
  
INSERT INTO minor (
MINOR_CODE,		MAJOR_CODE,		PROFESSOR_USER_CODE,	MINOR_NAME,
MINOR_SCORE,	USE_YN
)
VALUES 
(1001,			001,			1,			'데이터베이스설계',
3,				'Y'),
(2001,			002,			3,			'경영학원론',
2,				'Y'),
(3001,			003,			2,			'통계학',
3,				'Y');
  
SELECT *
  FROM minor;

  
 