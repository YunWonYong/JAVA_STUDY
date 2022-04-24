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

-- 교수추가
INSERT INTO login_info (ID, Password)
VALUES 
('jpark', '0000'),
('iu', '1111'),
('heedo', '2222'),
('byj1015', '3333'),
('yurimk', '4444'),
('Seungwan', '5555'),
('jiwoo', '666666'),
('wooshik', '777'),
('dami', '8888'),
('seoha', '9999');

SELECT *
  FROM login_info;

INSERT INTO user_info (
ID,				NAME,				ENG_NAME,		GENDER,
BIRTH_DATE,		REAL_NUMBER,		ZIP_CODE,		ADDRESS,
ADDRESS_DTL,	EMAIL,				EMAIL_ADDRESS,	PHONE_NUMBER)
VALUES 
('jpark', 		'박재범',				'Jpark',		'M',
 19870425,		 8704251111111,		15155,			'주소1',
 '101호',		 'jpark',			'icloud.com',	 '01087541120'),
('iu', 			'이지은',				'iu',			'F',
19930516,		 9305162222222,		85460,			'주소2',	
'202호',		 	'dlwldms',			'naver.com',	 '01096548512'),
('heedo', 		'나희도',				'heedo Na',		'F',
 19820723,		 8207234444444,		12456,			'주소3',
 '303호',		 'heedo12',			'gmail.com',	 '01055674138'),
('byj1015', 	'백이진',				'yijin Baek',	'M',
19771015,		 7710156666666,		13579,			'주소4',	
'404호',		 	'byj1015',			'ubs.com',	 	'01023754698'),
('yurimk', 		'고유림',				'yurim Ko',		'F',
 19820412,		 8204124444444,		96541,			'주소5',
 '505호',		 'yukimko',			'icloud.com',	 '01056423354'),
('Seungwan', 	'지승완',				'Seungwan Ji',	'F',
19821106,		 8211064444444,		22005,			'주소6',	
'606호',		 	'Seungwan',			'naver.com',	 '01085462159'),
('jiwoo', 		'문지웅',				'jiwoong Moon',	 'M',
 19820322,		 8203225555555,		56741,			'주소7',
 '707호',		 'woong',			'icloud.com',	 '01058964531'),
('wooshik', 	'최우식',				'wooshik Choi',	'M',
19900326,		 9003268888888,		25416,			'주소8',	
'808호',		 	'wooshik',			'naver.com',	 '01025471985'),
('dami', 		'김다미',				'dami Kim',		'F',
 19950409,		 9504067777777,		65423,			'주소9',
 '909호',		 'dami',			'icloud.com',	 '01065712398'),
('seoha', 		'주서하',				'seoha Joo',	 'F',
20010521,		 010521,			15548,			'주소10',	
'100호',		 	'seoha',			'naver.com',	 '01054782221');

SELECT *
  FROM user_info;
