create database fourman character set=utf8;
commit;

USE fourman;

CREATE TABLE TEST(
NAME CHAR(30)
);

-- Admin
DROP TABLE ADMIN_L;
DROP TABLE ADMIN;


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
set sql_safe_updates=0;

INSERT INTO ADMIN (aNO, aID, aPW, aEMAIL, aNAME, aTEL, aLEVEL)
    VALUES((SELECT get_seq('file')), 'moan125', '1234', 'moan125@naver.com', '문희석', '010-9999-1234', 2);
INSERT INTO ADMIN (aNO, aID, aPW, aEMAIL, aNAME, aTEL, aLEVEL)
    VALUES((SELECT get_seq('file')), 'aaa', '1234', 'lee@naver.com', '이진우', '010-1111-1234', 1);
INSERT INTO ADMIN (aNO, aID, aPW, aEMAIL, aNAME, aTEL, aLEVEL)
    VALUES((SELECT get_seq('file')), 'bbb', '1234', 'kim@naver.com', '김민우', '010-2222-1234', 1);
INSERT INTO ADMIN (aNO, aID, aPW, aEMAIL, aNAME, aTEL, aLEVEL)
    VALUES((SELECT get_seq('file')), 'ccc', '1234', 'ryu@naver.com', '류지환', '010-3333-1234', 1);

commit;
SELECT * FROM ADMIN;

CREATE SEQUENCE ADMIN_SQ
INCREMENT BY 1
MAXVALUE 99 NOCACHE NOCYCLE;

-- ADMIN LELVE DATA
INSERT INTO ADMIN_L VALUES(0, 'MANAGER');
INSERT INTO ADMIN_L VALUES(1, 'HEAD_MANAGER');
INSERT INTO ADMIN_L VALUES(2, 'MASTER');

SELECT * FROM ADMIN;
SELECT * FROM ADMIN_L;



-- 어드민용 시퀀스 만들기

-- 테이블 생성
CREATE TABLE master_seq(
	id int not null,
    seq_name varchar(50) not null
);

-- 함수 제작
DROP FUNCTION IF EXISTS get_seq;
DELIMITER $$
CREATE FUNCTION get_seq(p_seq_name VARCHAR(45))
RETURNS INT READS SQL DATA
BEGIN
DECLARE RESULT_ID INT;
UPDATE master_seq SET id = LAST_INSERT_ID(id+1)
WHERE seq_name = p_seq_name;
SET RESULT_ID = (SELECT LAST_INSERT_ID());
RETURN RESULT_ID;
END $$
DELIMITER ;

-- 시퀀스 생성
INSERT INTO master_seq VALUES(1, 'file');

-- 이걸로 시퀀스 호출
SELECT get_seq('file');






CREATE TABLE SEQUENCES(
	NAME VARCHAR(32),
    CURRVAL BIGINT UNSIGNED
)
ENGINE = InnoDB

DELIMITER $$
	CREATE PROCEDURE 'create_sequence' (IN the_name text)
    MODIFIES SQL DATA
    DETERMINISTIC
    BEGIN
		DELETE FROM sequences WHERE name = the_name;
        INSERT INTO sequences VALUES(the_name, 0);
	END

DELIMITER $$
	CREATE FUNCTION 'nextval' (the_nmae VARCHAR(32))
    RETURNS BIGINT UNSIGNED



DROP FUNCTION IF EXISTS get_seq;

DELIMITER $$
CREATE FUNCTION get_seq(p_seq_name VARCHAR(45))
RETURNS INT READS SQL DATA
BEGIN
DECLARE RESULT_ID INT;
UPDATE seq_mysql SET id = LIST_INSET_ID(id+1)
WHERE ano = p_seq_name;
SET RESULT_ID = (SELECT LAST_INSET_ID());
RETURN RESULT_ID;
END $$
DELIMITER ;

INSERT INTO seq_mysql
VALUES (0, 'adminno');

CALL create_sequence('Test');
get_seq('adminno');


CREATE TABLE ADMIN(
    aNO int(2) PRIMARY KEY,
    aID VARCHAR(50) UNIQUE NOT NULL,
    aPW VARCHAR(50) NOT NULL,
    aEMAIL VARCHAR(50) NOT NULL,
    aNAME VARCHAR(50) NOT NULL,
    aTEL VARCHAR(50) NOT NULL,
    aLEVEL VARCHAR(50) DEFAULT 0
);

INSERT INTO ADMIN
	VALUES((SELECT get_seq('adminno') FROM DUAL), 'aaa', '1234', 'moan12@naver.com', '홍길동', '010-2222-3333', '김');
	
DROP TABLE ADMIN;



use mysql;
select user, host, password from user;
select user, host, authencation_string from user;


