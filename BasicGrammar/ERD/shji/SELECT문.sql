-- 사용자 정보 조회하기
SELECT A.ID 		AS ID
	  ,A.NAME 		AS 이름
	  ,A.ENG_NAME	AS 영문이름
      ,CASE WHEN A.GENDER = 'M' THEN '남성'
			WHEN A.GENDER = 'G' THEN '여성'
			ELSE '미상'		END AS 성별
	  ,CONCAT(LEFT(A.BIRTH_DATE, 4), '-', SUBSTRING(A.BIRTH_DATE, 5, 2), '-', RIGHT(A.BIRTH_DATE, 2)) AS 생년월일
      ,CONCAT(A.ADDRESS, ' ', A.ADDRESS_DTL, '(', A.ZIP_CODE, ')') AS 주소
      ,CONCAT(A.EMAIL, '@', A.EMAIL_ADDRESS)		 AS 이메일
      ,CONCAT(LEFT(A.PHONE_NUMBER, 3), '-', SUBSTRING(A.PHONE_NUMBER, 4, 4), '-', RIGHT(A.PHONE_NUMBER, 4)) AS 전화번호
  FROM USER_INFO AS A;
  
-- 학과 담당교수 조회
SELECT B.MAJOR_NAME  AS 학과명
	  ,C.NAME		 AS 담당교수
  FROM PROFESSOR AS A 
	LEFT JOIN MAJOR AS B 
		   ON B.PROFESSOR_HEAD_USER_CODE = A.PROFESSOR_CODE
	LEFT JOIN USER_INFO AS C
		   ON C.ID = A.ID;

-- 학과별 개설과목 조회
SELECT A.MAJOR_NAME	 AS 학과명
	  ,B.MINOR_NAME	 AS 과목명
	  ,E.NAME		 AS 담당교수
      ,B.MINOR_SCORE AS 수강학점
  FROM MAJOR AS A 
	LEFT JOIN MINOR AS B
		   ON B.MAJOR_CODE = A.MAJOR_CODE
	LEFT JOIN PROFESSOR AS C
		   ON C.PROFESSOR_CODE = B.PROFESSOR_USER_CODE
	LEFT JOIN USER_INFO AS E
		   ON E.ID = C.ID;

-- 과목별 수강학생 조회(학기별로 구분해야함)
SELECT A.MINOR_NAME		AS 과목명
	  -- ,B.MINOR_CODE		AS 과목코드
      -- ,B.STUDENT_CODE	AS 학생코드
      ,B.GRADE			AS 학년
      ,D.NAME			AS 학생명 
  FROM MINOR AS A
	LEFT JOIN STUDENT_SEMESTER AS B
		   ON B.MINOR_CODE = A.MINOR_CODE
	LEFT JOIN STUDENT AS C
		   ON C.STUDENT_CODE = B.STUDENT_CODE
	LEFT JOIN USER_INFO AS D
		   ON D.ID = C.ID
 WHERE B.SEMESTER = 1;		
  
-- 학생의 학과 조회
-- ALTER TABLE STUDENT_GRADE change GRANDE GRADE CHAR(1); 컬럼명 변경
SELECT A.STUDENT_CODE AS 학생코드
	  ,B.NAME		  AS 이름
	  ,C.GRADE		  AS 학년
      ,D.MAJOR_NAME	  AS 학과
  FROM STUDENT AS A 
		LEFT JOIN USER_INFO AS B
			   ON B.ID = A.ID
		LEFT JOIN STUDENT_GRADE AS C
			   ON C.STUDENT_CODE = A.STUDENT_CODE
			  AND C.GRADE		 = A.GRADE
		LEFT JOIN MAJOR AS D
			   ON D.MAJOR_CODE	= C.MAJOR_CODE;

-- 학생 수강과목 조회
SELECT A.STUDENT_CODE AS 학생코드
	  ,B.NAME		  AS 이름
	  ,C.GRADE		  AS 학년
      ,D.MAJOR_NAME	  AS 학과
      ,E.SEMESTER 	  AS 학기
      ,F.MINOR_NAME	  AS 수강과목
  FROM STUDENT AS A 
		LEFT JOIN USER_INFO AS B
			   ON B.ID = A.ID
		LEFT JOIN STUDENT_GRADE AS C	
			   ON C.STUDENT_CODE = A.STUDENT_CODE
			  -- AND C.GRADE		 = A.GRADE
		LEFT JOIN MAJOR AS D
			   ON D.MAJOR_CODE	= C.MAJOR_CODE
		LEFT JOIN STUDENT_SEMESTER AS E
			   ON E.STUDENT_CODE = C.STUDENT_CODE
			  AND E.GRADE		 = C.GRADE
		LEFT JOIN MINOR AS F
			   ON F.MINOR_CODE 	 = E.MINOR_CODE
  WHERE A.STUDENT_CODE = 'S000000001'
 ORDER BY A.STUDENT_CODE, C.GRADE, E.SEMESTER;

