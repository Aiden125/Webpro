DROP TABLE GAME;

CREATE TABLE GAME(
    userID VARCHAR2(30) PRIMARY KEY,
    userPW VARCHAR2(30) NOT NULL
);


-- 전체조회
SELECT * FROM GAME;

-- 입력
INSERT INTO GAME VALUES('홍길동', '111');

--  검색
SELECT userPW FROM GAME WHERE userID='aaa';

COMMIT;









