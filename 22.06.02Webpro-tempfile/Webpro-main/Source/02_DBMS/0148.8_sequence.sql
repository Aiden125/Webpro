-- [VIII] SEQUENCE : ������ȣ ������, �������� PK ��� �뵵
DROP SEQUENCE FRIEND_SEQ; --������ �����ϱ�(�ִ��� ������ �𸣱⿡ �ϴ� ����)
CREATE SEQUENCE FRIEND_SEQ
    START WITH 1 -- 1�� ���� ������ �����ϱ�.
    INCREMENT BY 1 -- 1�� Ŀ���� �ϱ�
    MAXVALUE 9999 -- �ִ� ����� Ŀ�� �� �ְ����� ����
    MINVALUE 1 -- �ּ� ����
    NOCACHE -- ��ǻ�͸� ���� �ѵ� �ʱ�ȭ�����ʰ�.
    NOCYCLE; -- �ִ��� 9999���� ���� ������ �߻� ��Ŵ. ���� ���� ���ϸ� �ٽ� 1�� ���ư��� �ݺ�
    
CREATE SEQUENCE FRIEND_SEQ2 -- ������ �Ȱ���. ���� �����Ѱ� �� �� ��
    MAXVALUE 9999 -- �ִ� ����� Ŀ�� �� �ְ����� ����
    NOCACHE
    NOCYCLE;

SELECT FRIEND_SEQ.NEXTVAL FROM DUAL;
DROP SEQUENCE FRIEND_SEQ;
CREATE SEQUENCE FRIEND_SEQ
    MAXVALUE 9999
    NOCACHE
    NOCYCLE;
DROP TABLE FRIEND;
CREATE TABLE FRIEND(
    NUM NUMBER(4) PRIMARY KEY, --������ �̿�
    NAME VARCHAR2(30) NOT NULL,
    TEL VARCHAR2(30) UNIQUE, -- NULL���, ������ ��
    ADDRESS VARCHAR2(300),
    LAST_MODIFYED DATE DEFAULT SYSDATE);

INSERT INTO FRIEND(NUM, NAME, TEL, ADDRESS)
    VALUES(FRIEND_SEQ.NEXTVAL, '�����',  NULL, '����� ��걸');
    
INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
    VALUES(FRIEND_SEQ.NEXTVAL, 'Ⱦ��', NULL, '����� ������');
-- [VIII] SEQUENCE : ������ȣ ������, �������� PK ��� �뵵
DROP SEQUENCE FRIEND_SEQ; --������ �����ϱ�(�ִ��� ������ �𸣱⿡ �ϴ� ����)
CREATE SEQUENCE FRIEND_SEQ
    START WITH 1 -- 1�� ���� ������ �����ϱ�.
    INCREMENT BY 1 -- 1�� Ŀ���� �ϱ�
    MAXVALUE 9999 -- �ִ� ����� Ŀ�� �� �ְ����� ����
    MINVALUE 1 -- �ּ� ����
    NOCACHE -- ��ǻ�͸� ���� �ѵ� �ʱ�ȭ�����ʰ�.
    NOCYCLE; -- �ִ��� 9999���� ���� ������ �߻� ��Ŵ. ���� ���� ���ϸ� �ٽ� 1�� ���ư��� �ݺ�
    
CREATE SEQUENCE FRIEND_SEQ2 -- ������ �Ȱ���. ���� �����Ѱ� �� �� ��
    MAXVALUE 9999 -- �ִ� ����� Ŀ�� �� �ְ����� ����
    NOCACHE
    NOCYCLE;

SELECT FRIEND_SEQ.NEXTVAL FROM DUAL;
DROP SEQUENCE FRIEND_SEQ;
CREATE SEQUENCE FRIEND_SEQ
    MAXVALUE 9999
    NOCACHE
    NOCYCLE;
DROP TABLE FRIEND;
CREATE TABLE FRIEND(
    NUM NUMBER(4) PRIMARY KEY, --������ �̿�
    NAME VARCHAR2(30) NOT NULL,
    TEL VARCHAR2(30) UNIQUE, -- NULL���, ������ ��
    ADDRESS VARCHAR2(300),
    LAST_MODIFYED DATE DEFAULT SYSDATE);

INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
    VALUES(FRIEND_SEQ.NEXTVAL, 'Ⱦ��', NULL, '����� ������');
SELECT * FROM FRIEND;
INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
    VALUES (FRIEND_SEQ.NEXTVAL, '�ű浿', '010-2222-3333','����� ��������');
INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
    VALUES (FRIEND_SEQ.NEXTVAL, '�ű浿', '010-2222-3333','����� ��������');
SELECT * FROM FRIEND;

SELECT FRIEND_SEQ.CURRVAL FROM DUAL; -- ���� ������ ��
COMMIT;


-- EX. �ʱⰪ 101���� �ִ밪 999,999���� 1�� �����ϴ� TEST_SEQ �������� ����
CREATE SEQUENCE TEST_SEQ START WITH 101 MAXVALUE 999999 NOCACHE;
SELECT TEST_SEQ.CURRVAL FROM DUAL; -- �������� ���� ���� ��� ����
SELECT TEST_SEQ.NEXTVAL FROM DUAL;





-- �������� PDF4��
DROP TABLE BOOKCATEGORY;
DROP TABLE BOOK;

CREATE TABLE BOOKCATEGORY (
    CATEGORY_CODE VARCHAR2(10) PRIMARY KEY,
    CATEGORY_NAME VARCHAR2(50) UNIQUE,
    OFFICE_LOC VARCHAR2(50) NOT NULL);

INSERT INTO BOOKCATEGORY VALUES(100, 'ö��', '3�� �ι���');
INSERT INTO BOOKCATEGORY VALUES(200, '�ι�', '3�� �ι���');
INSERT INTO BOOKCATEGORY VALUES(300, '�ڿ�����', '4�� ���н�');
INSERT INTO BOOKCATEGORY VALUES(400, 'IT', '4�� ���н�');
SELECT * FROM BOOKCATEGORY;

CREATE TABLE BOOK (
    BOOKNO VARCHAR2(10) PRIMARY KEY, 
    CATEGORY_CODE VARCHAR2(10) REFERENCES BOOKCATEGORY(CATEGORY_CODE),
    BOOKNAME VARCHAR(50),
    PUBLISHER VARCHAR(50),
    PUBYEAR NUMBER(4) DEFAULT TO_NUMBER(TO_CHAR(SYSDATE, 'YYYY')));

--�Ʒ�ó�� ����Ʈ ������ �ֱ����ؼ��� �÷� ��ø� �ݵ�� �������
INSERT INTO BOOK (BOOKNO, CATEGORY_CODE, BOOKNAME, PUBLISHER)
VALUES('100A01', 100, 'ö������ ��', '��������');
INSERT INTO BOOK (BOOKNO, CATEGORY_CODE, BOOKNAME, PUBLISHER)
VALUES('400A01', 400, '�̰��� DB��', '��������');
SELECT * FROM BOOK;

SELECT * FROM BOOKCATEGORY;
SELECT * FROM BOOK;




-- �������� PDF5��
DROP TABLE STUDENT;
DROP TABLE MAJOR;
DROP SEQUENCE MAJOR_SEQ;

CREATE TABLE MAJOR(
    MAJOR_CODE NUMBER(4) PRIMARY KEY,
    MAJOR_NAME VARCHAR2(30) UNIQUE,
    MAJOR_OFFICE_LOC VARCHAR2(30) NOT NULL);

INSERT INTO MAJOR VALUES(MAJOR_SEQ.NEXTVAL, '�濵����', '�濵�� 305ȣ');
INSERT INTO MAJOR VALUES(MAJOR_SEQ.NEXTVAL, '����Ʈ�������', '������ 808ȣ');
INSERT INTO MAJOR VALUES(MAJOR_SEQ.NEXTVAL, '������', '������ 606ȣ');
INSERT INTO MAJOR VALUES(MAJOR_SEQ.NEXTVAL, '����', '���� 202ȣ');

SELECT * FROM MAJOR;

CREATE TABLE STUDENT(
    STUDENT_CODE VARCHAR(20) PRIMARY KEY,
    MAJOR_CODE NUMBER(4) REFERENCES MAJOR(MAJOR_CODE),
    STUDENT_NAME VARCHAR(20) NOT NULL,
    SCORE NUMBER(3) CHECK(0<=SCORE AND SCORE<=100));

INSERT INTO STUDENT (STUDENT_CODE, STUDENT_NAME, SCORE, MAJOR_CODE)
VALUES ('A01', '��浿', 100, 1);
INSERT INTO STUDENT (STUDENT_CODE, STUDENT_NAME, SCORE, MAJOR_CODE)
VALUES ('A02', '���浿', 90, 2);
INSERT INTO STUDENT (STUDENT_CODE, STUDENT_NAME, SCORE, MAJOR_CODE)
VALUES ('A03', 'ȫ�浿', 95, 1);
SELECT * FROM STUDENT;






-- �� ��������1(8page ����)
--������ ���� ������ ���̺��� �����ϰ� �����͸� �Է��ϴ� SQL���� ���ǿ� �°� �ۼ��Ͽ�
--ex1.sql���ϰ� ���� ĸó����(ex1.jpg�� ex1.png)�� �����Ͻÿ�.
--[�䱸����]
--(1) ���� �̸��� ���̺��̳� �������� ���� �� ������ ���� �����ϰ� ���̺��� �����Ͻÿ�
DROP TABLE MEMBER;
DROP TABLE MEMBER_LEVEL;
DROP SEQUENCE MEMBER_MNO_SQ;
--(2) MEMBER ���̺��� �ʵ� ���� ������ ������ ���� �����Ͻÿ�.
--	�� mNO(��ȣ) : ��Ű
--	�� mNAME(�̸�) : NULL���� �Է��� �� ����
--	�� mPW(��й�ȣ) : �ݵ�� 1~8���� �̳��� ���ڸ� �Է��Ѵ�
--	�� mEMAIL(����) : ��� �����ʹ� EMAIL �ʵ尪�� ��� �ٸ��� �Էµȴ�.
--	�� mPOINT(����Ʈ) : 0�̻��� ���� �Է��� �� �ִ�.
--	�� mRDATE(������) : �Է����� ���� ��, �⺻������ ���糯¥�� �Էµȴ�.
--  �� LEVELNO : MEMBER_LEVEL ���̺��� LEVELNO �ʵ带 �����ϴ� �ܷ�Ű
CREATE TABLE MEMBER(
    mNO NUMBER(4) PRIMARY KEY,
    mNAME VARCHAR2(20) NOT NULL,
    mPW VARCHAR2(8) CHECK (LENGTH(mPW)>=1),
    mEMAIL VARCHAR2(20) UNIQUE,
    mPOINT NUMBER(8) CHECK (mPOINT>=0),
    mRDATE DATE DEFAULT SYSDATE,
    LEVELNO NUMBER(3) REFERENCES MEMBER_LEVEL(LEVELNO));
    

--(3) MEMBER_LEVEL ���̺��� �ʵ� ���� ������ ���������� ��Ų��.
--	�� LEVELNO : ��Ű
--	�� LEVELNAME : NULL���� �Է��� �� ����	
CREATE TABLE MEMBER_LEVEL(
    LEVELNO NUMBER(3) PRIMARY KEY,
    LEVELNAME VARCHAR2(20) NOT NULL);
    
--(4) MEMBER ���̺��� mNO��ȣ�� ������(MEMBER_MNO_SQ)�� ������ �� �ڵ����� ��ȣ�� �Է�
CREATE SEQUENCE MEMBER_MNO_SQ
    START WITH 1 -- 1�� ���� ������ �����ϱ�.
    INCREMENT BY 1 -- 1�� Ŀ���� �ϱ�
    MAXVALUE 9999 -- �ִ� ����� Ŀ�� �� �ְ����� ����
    MINVALUE 1 -- �ּ� ����
    NOCACHE -- ��ǻ�͸� ���� �ѵ� �ʱ�ȭ ���� �ʰ�.
    NOCYCLE; -- �ִ��� 9999���� ���� ������ �߻� ��Ŵ. ���� ���� ���ϸ� �ٽ� 1�� ���ư��� �ݺ�

INSERT INTO MEMBER_LEVEL VALUES (-1, 'BLACK');
INSERT INTO MEMBER_LEVEL VALUES (0, '�Ϲ�');
INSERT INTO MEMBER_LEVEL VALUES (1, '�ǹ�');
INSERT INTO MEMBER_LEVEL VALUES (2, '���');
SELECT * FROM MEMBER_LEVEL;

INSERT INTO MEMBER (mNO, mNAME, mPW, mEMAIL, mPOINT, mRDATE, LEVELNO)
VALUES (MEMBER_MNO_SQ.NEXTVAL, 'ȫ�浿', 'aa', 'hong@hong.com', 0, '22/03/10', 0);
INSERT INTO MEMBER (mNO, mNAME, mPW, mEMAIL, mPOINT, mRDATE, LEVELNO)
VALUES (MEMBER_MNO_SQ.NEXTVAL, '�ű浿', 'bb', 'sin@sin.com', 1000, '22/04/01', 1);
SELECT * FROM MEMBER;

SELECT mNO, mNAME, mRDATE, mEMAIL, mPOINT, LEVELNAME
    FROM MEMBER M, MEMBER_LEVEL L
    WHERE M.LEVELNO=L.LEVELNO;



