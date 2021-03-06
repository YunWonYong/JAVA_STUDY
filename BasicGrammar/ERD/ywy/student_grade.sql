DELETE 
  FROM  STUDENT_GRADE
 WHERE  STUDENT_CODE IN ('S000000001', 'S000000002');
  
INSERT INTO STUDENT_GRADE(GRADE, STUDENT_CODE, MAJOR_CODE)
VALUES (1, 'S000000001', '01')
     , (1, 'S000000002', '03')
     , (2, 'S000000001', '01')   
     , (2, 'S000000002', '03');
     
SELECT  *
  FROM  STUDENT_GRADE;


SELECT  USER.ID
     ,  USER.NAME
     ,  USER.BIRTH_DATE
     ,  USER.GENDER
     ,  USER.PHONE_NUMBER
     ,  STUDENT.STUDENT_CODE
  FROM  USER_INFO AS USER
 INNER
  JOIN  STUDENT AS STUDENT
    ON  USER.ID = STUDENT.ID;
  
SELECT  (
         SELECT USER.NAME
           FROM  USER_INFO AS USER
          WHERE  USER.ID = (
							SELECT  STUDENT.ID
							  FROM  STUDENT AS STUDENT
							 WHERE  STUDENT.STUDENT_CODE = GRADE.STUDENT_CODE
						   ) 
		) AS STUDENT_NAME
     ,  (
         SELECT USER.NAME
           FROM  USER_INFO AS USER
          WHERE  USER.ID = (
							SELECT  PROFESSOR.ID
							  FROM  PROFESSOR AS PROFESSOR
							 WHERE  PROFESSOR.PROFESSOR_CODE = MAJOR.PROFESSOR_HEAD_USER_CODE
						   ) 
		) AS PROFESSOR_NAME
     ,  MAJOR.MAJOR_NAME
  FROM  STUDENT_GRADE AS GRADE
 INNER
  JOIN  MAJOR AS MAJOR
    ON  GRADE.MAJOR_CODE = MAJOR.MAJOR_CODE
    