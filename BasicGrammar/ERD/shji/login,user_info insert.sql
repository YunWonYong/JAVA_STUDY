USE mydb;
-- 교수
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
('shji', 		'지서향',				'Ji Seohyang',  'G',
20010723,		'0107231111111',  	11111,	    	'경기도 안산시',
'000동 0000호',	'ksk076', 		  	'naver.com',	'01012345678'),
('test', 		'테스트',				'Test', 		'M',
20220302,		'2203021111111',  	22222,	    	'서울시',
'222동 2002호',	'test', 		  	'daum.net',		'01022222222'),
('hong', 		'홍길동',				'Hong gildong',  'G',
20000302,		'0003021111111',  	22222,	    	'광명시',
'302동 1702호',	'hong0302', 		'gmail.com',	'01034567890');

SELECT *
  FROM user_info;

-- 학생  
INSERT INTO login_info (ID, Password)
VALUES 
('stu1', '0000'),
('stu2', '1111'),
('stu3', '2222'),
('stu4', '3333'),
('stu5', '4444'),
('stu6', '5555'),
('stu7', '666666'),
('stu8', '777'),
('stu9', '8888'),
('stu10', '9999');

SELECT *
  FROM login_info
 WHERE ID LIKE 'STU%';

INSERT INTO user_info (
ID,				NAME,				ENG_NAME,		GENDER,
BIRTH_DATE,		REAL_NUMBER,		ZIP_CODE,		ADDRESS,
ADDRESS_DTL,	EMAIL,				EMAIL_ADDRESS,	PHONE_NUMBER)
VALUES 
('stu1', 		'학생1',				'Student1',		'F',
 20001203,		 0012031111111,		12123,			'주소1',
 '101호',		 'studd11',			'icloud.com',	 '01011112222'),
('stu2', 		'학생2',				'Student2',		'M',
20000811,		 0008111111111,		22234,			'주소2',	
'202호',		 	's22',				'naver.com',	 '01013443222'),
('stu3', 		'학생3',				'Student3',		'F',
 20010322,		 0103221111111,		00332,			'주소3',
 '303호',		 'st0322',			'gmail.com',	 '01003223333'),
('stu4', 		'학생4',				'Student4',		'M',
20000130,		 0001301111111,		13579,			'주소4',	
'404호',		 	'stud40444',		'naver.com',	 '01013444122'),
('stu5', 		'학생5',				'Student5',		'F',
 20000926,		 0009261111111,		00003,			'주소5',
 '505호',		 'st0926',			'icloud.com',	 '01099230222'),
('stu6', 		'학생6',				'Student6',		'M',
20000402,		 0004021111111,		22005,			'주소6',	
'606호',		 	'sss66stu',			'naver.com',	 '01085471123'),
('stu7', 		'학생7',				'Student7',		'F',
 20000507,		 0005071111111,		98002,			'주소7',
 '707호',		 'stu707',			'icloud.com',	 '01076459542'),
('stu8', 		'학생8',				'Student8',		'M',
20000811,		 0008111111111,		88052,			'주소8',	
'808호',		 	'st8988',			'naver.com',	 '01098561486'),
('stu9', 		'학생9',				'Student9',		'F',
 20000521,		 0005211111111,		55412,			'주소9',
 '909호',		 'stud9',			'icloud.com',	 '01023845697'),
('stu10', 		'학생10',			'Student10',		'M',
20000104,		 0001041111111,		63547,			'주소10',	
'100호',		 	'tu1010',			'naver.com',	 '01056964798');

SELECT *
  FROM user_info
  WHERE ID LIKE 'STU%';