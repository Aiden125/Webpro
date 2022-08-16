-- Admin
DROP TABLE ADMIN_L;
DROP TABLE ADMIN_SEQ;
DROP TABLE ADMIN;

-- 어드민용 시퀀스 만들기

-- 테이블 생성
CREATE TABLE admin_seq(
	id INT NOT NULL,
    seq_name VARCHAR(50)
);

-- 함수 제작
DROP FUNCTION IF EXISTS get_admin_seq;
DELIMITER $$
CREATE FUNCTION get_admin_seq(p_seq_name VARCHAR(45))
RETURNS INT READS SQL DATA
BEGIN
DECLARE RESULT_ID INT;
UPDATE admin_seq SET id = LAST_INSERT_ID(id+1)
WHERE seq_name = p_seq_name;
SET RESULT_ID = (SELECT LAST_INSERT_ID());
RETURN RESULT_ID;
END $$
DELIMITER ;

-- 시퀀스 생성
INSERT INTO admin_seq VALUES(0, 'ano');

-- 이걸로 시퀀스 호출
SELECT get_admin_seq('ano');




CREATE TABLE ADMIN(
    aNO int(2) PRIMARY KEY,
    aID VARCHAR(50) UNIQUE NOT NULL,
    aPW VARCHAR(50) NOT NULL,
    aEMAIL VARCHAR(50) NOT NULL,
    aNAME VARCHAR(50) NOT NULL,
    aTEL VARCHAR(50) NOT NULL,
    aLEVEL VARCHAR(50) DEFAULT 0,
    aRDATE DATETIME DEFAULT current_timestamp,
    FOREIGN KEY (aLEVEL) REFERENCES ADMIN_L
);

-- ADMIN LEVEL
CREATE TABLE ADMIN_L(
    aLEVEL VARCHAR(10) PRIMARY KEY,
    aLEVEL_NAME VARCHAR(50)
);

-- ADMIN LELVE DATA
INSERT INTO ADMIN_L VALUES(0, 'MANAGER');
INSERT INTO ADMIN_L VALUES(1, 'HEAD_MANAGER');
INSERT INTO ADMIN_L VALUES(2, 'MASTER');

SELECT * FROM ADMIN;
SELECT * FROM ADMIN_L;



