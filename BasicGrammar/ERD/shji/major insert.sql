USE mydb;

SELECT * FROM PROFESSOR;
    
INSERT INTO major (
MAJOR_CODE,		PROFESSOR_HEAD_USER_CODE,	MAJOR_NAME,		MAJOR_PHONE_NUMBER,
USE_YN
)
VALUES 
((SELECT A.CODE
   FROM(SELECT LPAD(IFNULL(MAX(CAST(MAJOR_CODE AS unsigned)),0) + 1, 2, 0) AS CODE
          FROM major) AS A),		
(SELECT A.PH
   FROM(SELECT PROFESSOR_CODE AS PH
          FROM professor
		 WHERE PROFESSOR_CODE = 'P000000001') AS A),		
'컴퓨터공학과',		
'02-1234-5678',
'Y'),
((SELECT A.CODE
   FROM(SELECT LPAD(IFNULL(MAX(CAST(MAJOR_CODE AS unsigned)),0) + 1, 2, 0) AS CODE
          FROM major) AS A),		
(SELECT A.PH
   FROM(SELECT PROFESSOR_CODE AS PH
          FROM professor
		 WHERE PROFESSOR_CODE = 'P000000003') AS A),		
'경영학과',		
'02-3456-7890',
'Y'),
((SELECT A.CODE
   FROM(SELECT LPAD(IFNULL(MAX(CAST(MAJOR_CODE AS unsigned)),0) + 1, 2, 0) AS CODE
          FROM major) AS A),		
(SELECT A.PH
   FROM(SELECT PROFESSOR_CODE AS PH
          FROM professor
		 WHERE PROFESSOR_CODE = 'P000000002') AS A),		
'수학과',			
'02-0987-6543',
'Y');

SELECT *
  FROM major;