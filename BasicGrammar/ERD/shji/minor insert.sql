SELECT * FROM MAJOR;
SELECT * FROM MINOR;

-- MAJOR_CODE별로 1,2,3... 순서로 채번이 되어야 하는데 minor 테이블에 해당 major가 없어서 null값 insert 불가함

INSERT INTO minor (
MINOR_CODE,		MAJOR_CODE,		PROFESSOR_USER_CODE,	MINOR_NAME,
MINOR_SCORE,	USE_YN
)
VALUES 
((SELECT A.CODE
  FROM (
	SELECT CONCAT('01',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '01') AS A),			
'01',			
'P000000001',			
'데이터베이스설계',
3,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('01',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '01') AS A),			
'01',			
'P000000001',			
'JAVA',
3,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('01',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '01') AS A),			
'01',			
'P000000001',			
'C++',
3,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('01',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '01') AS A),			
'01',			
'P000000001',			
'C',
3,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('01',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '01') AS A),			
'01',			
'P000000001',			
'Algorithm',
3,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('01',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '01') AS A),			
'01',			
'P000000001',			
'HTML5',
3,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('01',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '01') AS A),			
'01',			
'P000000001',			
'JSP 프로그래밍',
3,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('02',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor 
     WHERE MAJOR_CODE = '02') AS A),			
'02',			
'P000000003',			
'경영학원론',
2,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('03',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	  WHERE MAJOR_CODE = '03') AS A),			
'03',			
'P000000002',			
'통계학',
3,				
'Y');

-- 실용음악과 개설과목
INSERT INTO minor (
MINOR_CODE,		MAJOR_CODE,		PROFESSOR_USER_CODE,	MINOR_NAME,
MINOR_SCORE,	USE_YN
)
VALUES 
((SELECT A.CODE
  FROM (
	SELECT CONCAT('05',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '05') AS A),			
'05',			
'P000000004',			
'실용음악이론',
3,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('05',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '05') AS A),			
'05',			
'P000000004',			
'팝앙상블',
3,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('05',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '05') AS A),			
'05',			
'P000000005',			
'음악사',
2,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('05',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '05') AS A),			
'05',			
'P000000005',			
'클래식피아노',
2,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('05',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '05') AS A),			
'05',			
'P000000005',			
'기초리듬연구',
3,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('05',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '05') AS A),			
'05',			
'P000000004',			
'재즈앙상블',
3,				
'Y');

select * from minor where MAJOR_CODE = 05;

-- 체육교육과 개설과목
INSERT INTO minor (
MINOR_CODE,		MAJOR_CODE,		PROFESSOR_USER_CODE,	MINOR_NAME,
MINOR_SCORE,	USE_YN
)
VALUES 
((SELECT A.CODE
  FROM (
	SELECT CONCAT('06',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '06') AS A),			
'06',			
'P000000006',			
'체육교육론',
3,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('06',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '06') AS A),			
'06',			
'P000000006',			
'기계체조초급교수법',
2,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('06',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '06') AS A),			
'06',			
'P000000008',			
'스포츠사회학',
2,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('06',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '06') AS A),			
'06',			
'P000000008',			
'운동생리학',
4,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('06',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '06') AS A),			
'06',			
'P000000006',			
'운동역학',
4,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('06',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '06') AS A),			
'06',			
'P000000008',			
'수영초급교수법',
3,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('06',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '06') AS A),			
'06',			
'P000000006',			
'축구교수법',
3,				
'Y');

select * from minor where MAJOR_CODE = 06;

--언론정보학과
INSERT INTO minor (
MINOR_CODE,		MAJOR_CODE,		PROFESSOR_USER_CODE,	MINOR_NAME,
MINOR_SCORE,	USE_YN
)
VALUES 
((SELECT A.CODE
  FROM (
	SELECT CONCAT('07',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '07') AS A),			
'07',			
'P000000007',			
'매스컴이론',
2,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('07',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '07') AS A),			
'07',			
'P000000007',			
'정치커뮤니케이션',
2,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('07',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '07') AS A),			
'07',			
'P000000007',			
'취재보도론',
3,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('07',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '07') AS A),			
'07',			
'P000000007',			
'언론사상사',
2,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('07',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '07') AS A),			
'07',			
'P000000007',			
'온라인저널리즘',
3,				
'Y');

select * from minor where MAJOR_CODE = 07;

-- 패션디자인과
INSERT INTO minor (
MINOR_CODE,		MAJOR_CODE,		PROFESSOR_USER_CODE,	MINOR_NAME,
MINOR_SCORE,	USE_YN
)
VALUES 
((SELECT A.CODE
  FROM (
	SELECT CONCAT('08',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '08') AS A),			
'08',			
'P000000010',			
'패션인스피레이션',
2,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('08',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '08') AS A),			
'08',			
'P000000010',			
'동양복식사',
3,				
'N'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('08',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '08') AS A),			
'08',			
'P000000010',			
'입체패턴디자인',
4,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('08',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '08') AS A),			
'08',			
'P000000010',			
'섬유미술',
3,				
'N'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('08',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '08') AS A),			
'08',			
'P000000010',			
'패션디자인',
4,				
'Y');

select * from minor where MAJOR_CODE = 08;

-- 회화과
INSERT INTO minor (
MINOR_CODE,		MAJOR_CODE,		PROFESSOR_USER_CODE,	MINOR_NAME,
MINOR_SCORE,	USE_YN
)
VALUES 
((SELECT A.CODE
  FROM (
	SELECT CONCAT('09',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '09') AS A),			
'09',			
'P000000011',			
'기초회화',
3,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('09',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '09') AS A),			
'09',			
'P000000011',			
'드로잉입문',
3,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('09',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '09') AS A),			
'09',			
'P000000011',			
'인체해부학',
2,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('09',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '09') AS A),			
'09',			
'P000000011',			
'현대미술사',
2,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('09',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '09') AS A),			
'09',			
'P000000011',			
'회화',
4,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('09',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '09') AS A),			
'09',			
'P000000011',			
'기초평면',
3,				
'Y');

select * from minor where MAJOR_CODE = 09;

-- 광고홍보학과
INSERT INTO minor (
MINOR_CODE,		MAJOR_CODE,		PROFESSOR_USER_CODE,	MINOR_NAME,
MINOR_SCORE,	USE_YN
)
VALUES 
((SELECT A.CODE
  FROM (
	SELECT CONCAT('10',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '10') AS A),			
'10',			
'P000000012',			
'광고학개론',
4,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('10',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '10') AS A),			
'10',			
'P000000012',			
'광고와마케팅',
3,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('10',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '10') AS A),			
'10',			
'P000000012',			
'광고기획',
3,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('10',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '10') AS A),			
'10',			
'P000000012',			
'판매촉진론',
2,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('10',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '10') AS A),			
'10',			
'P000000012',			
'홍보관리론',
2,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('10',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '10') AS A),			
'10',			
'P000000012',			
'광고조사론',
2,				
'Y');

select * from minor where MAJOR_CODE = 10;

-- 영어영문학과
INSERT INTO minor (
MINOR_CODE,		MAJOR_CODE,		PROFESSOR_USER_CODE,	MINOR_NAME,
MINOR_SCORE,	USE_YN
)
VALUES 
((SELECT A.CODE
  FROM (
	SELECT CONCAT('04',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '04') AS A),			
'04',			
'P000000004',			
'영어학인문',
3,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('04',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '04') AS A),			
'04',			
'P000000004',			
'영어글쓰기',
3,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('04',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '04') AS A),			
'04',			
'P000000011',			
'영어학인문',
2,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('04',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '04') AS A),			
'04',			
'P000000004',			
'미국문화개관',
2,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('04',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '04') AS A),			
'04',			
'P000000011',			
'영어변천사',
4,				
'Y'),
((SELECT A.CODE
  FROM (
	SELECT CONCAT('04',
		 (LPAD(IFNULL(MAX(CAST(RIGHT(MINOR_CODE, 2) AS unsigned)),0) + 1, 2, 0))) AS CODE
	  FROM minor
	 WHERE MAJOR_CODE = '04') AS A),			
'04',			
'P000000011',			
'영어음성학',
4,				
'Y');

select * from minor where MAJOR_CODE = 04;

  
DELETE 
  FROM  minor
SELECT *
  FROM minor;