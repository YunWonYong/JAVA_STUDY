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
  
SELECT *
  FROM minor;