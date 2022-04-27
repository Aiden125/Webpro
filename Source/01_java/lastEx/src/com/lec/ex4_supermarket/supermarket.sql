--
DROP TABLE CUSTOMER;
-- DROP TABLE CUSTOMER CASCADE CONSTRAINTS;(�����ϴ� ��찡 �ִ� ��� ��������(���� �Ⱦ�����)
DROP TABLE CUS_LEVEL;
DROP SEQUENCE CUSTOMER_SQ;

CREATE TABLE CUS_LEVEL (
    LEVELNO NUMBER(2) PRIMARY KEY,
    LEVELNAME VARCHAR2(20),
    LOW NUMBER(10),
    HIGH NUMBER(10)
);

-- NORMAL 1 0 99999 / SILVER 2 100000 499999 / GOLD 3 500000 999999
-- / VIP 4 1000000 1999999 / VVIP 2000000 999999999

INSERT INTO CUS_LEVEL VALUES(1, 'NORMAL', 0, 99999);
INSERT INTO CUS_LEVEL VALUES(2, 'SILVER', 100000, 499999);
INSERT INTO CUS_LEVEL VALUES(3, 'GOLD', 500000, 999999);
INSERT INTO CUS_LEVEL VALUES(4, 'VIP', 1000000, 1999999);
INSERT INTO CUS_LEVEL VALUES(5, 'VVIP', 2000000, 999999999);

CREATE SEQUENCE CUSTOMER_SQ
MAXVALUE 999999
NOCACHE
NOCYCLE;

CREATE TABLE CUSTOMER (
    cID NUMBER(6) PRIMARY KEY,
    cTEL VARCHAR2(20) NOT NULL,
    cNAME VARCHAR2(30) NOT NULL,
    cPOINT NUMBER(10) DEFAULT 1000 CHECK(cPOINT>=0),
    cAMOUNT NUMBER(10) DEFAULT 0,
    LEVELNO NUMBER(2) DEFAULT 1 REFERENCES CUS_LEVEL(LEVELNO)
    -- �Ʒ��� �������� ���� ���.
    -- PRIMARY KEY(cID)
    -- FOREIGN KEY(LEVELNO) REFERENCES CUS_LEVEL(LEVELNO)
);

INSERT INTO CUSTOMER(cID, cTEL, cNAME)
    VALUES(CUSTOMER_SQ.NEXTVAL, '010-6666-6666', '�ڸ��');
INSERT INTO CUSTOMER(cID, cTEL, cNAME)
    VALUES(CUSTOMER_SQ.NEXTVAL, '010-3333-3333', '���缮');
INSERT INTO CUSTOMER(cID, cTEL, cNAME)
    VALUES(CUSTOMER_SQ.NEXTVAL, '010-5555-5555', '������');
INSERT INTO CUSTOMER VALUES (CUSTOMER_SQ.NEXTVAL, '010-7777-7777','���缮',0,5000000,5);
INSERT INTO CUSTOMER VALUES (CUSTOMER_SQ.NEXTVAL, '010-5231-5231','������',0,150000,2);

SELECT * FROM CUS_LEVEL;
SELECT * FROM CUSTOMER;


-- ����� 1���̻��� ��� ARRAYLIST�� ���
-- �ƴ� ��� �׳� ������ ��Ƶ� ��

-- 0. �����̸��� �˻� : public Vector<String> getLevelNames()
SELECT LEVELNAME FROM CUS_LEVEL;

-- 1. cId�� �˻�
-- ����Ű�� �ش��ϱ⿡ �� �ุ ���°��� ����(�迭�Ⱦ�)
-- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forlevelUP
-- public CustomerDto cIdGetCustomer(int cId)
SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME,
        (SELECT HIGH-cAMOUNT+1 FROM CUSTOMER WHERE CID=C.CID AND LEVELNO!=5) forLEVELUP
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO
    AND cid=4;
-- �� �������� �ܼ��� WHERE���� LEVELNO������ ������ �ƿ� ��� ��ü�� �ȵǱ� ������ ���������� �־������
    
    
-- 2. ����4�ڸ�(FULL) �˻�
-- �������� �� �� �ֱ⿡ ��̿� ����
-- public ArrayList<CustomerDto> cTelGetCustomers(String cTel);
-- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, �������� ���� �� ��
SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME,
    (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID=C.CID AND LEVELNO!=5) forLEVELUP
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO
    AND cTEL LIKE '%'||'6666'; -- �ڹٿ����� %�� ���ܾ��ϱ� ������ ���Ῥ���ڷ� ���� �س���

-- 3. ���̸��˻�
-- public ArrayList<CustomerDto> cNameGetCustomers(String cName);
-- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, �������� ���� �� ��
SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME,
    (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID=C.CID AND LEVELNO!=5) forLEVELUP
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO
    AND cNAME='���缮'
    ORDER BY cAMOUNT DESC;

-- 4. ����Ʈ�θ� ����(1000��¥���� ����Ʈ�θ� ����) : public int buyWithPoint(int cId, int cAmount)
UPDATE CUSTOMER SET cPOINT=cPOINT-1000 WHERE cID=1;

-- 5. ��ǰ���� (1000000��¥���� ������ ���. ����Ʈ�� ���űݾ��� 5%)
-- public int buy(int cId, int cAmount)
-- ��ǰ���� update���� cPoint, cAmount, levelNo ����

-- 5-1. cPOINT, cAMOUNT ����
UPDATE CUSTOMER SET cPOINT=cPOINT+(1000000*0.05), cAMOUNT=cAMOUNT+1000000
    WHERE cID=1;
SELECT * FROM CUSTOMER;

-- 5-2. ������ LEVELNO ��±���(�����ϱ� �� ��������ȣ�� �����ɷ�����ȣ)
SELECT cID, cNAME, cAMOUNT, C.LEVELNO ������, L.LEVELNO �����ɷ���
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE cAMOUNT BETWEEN LOW AND HIGH;

-- 5-3. LEVELNO ����
UPDATE CUSTOMER SET LEVELNO = (
SELECT L.LEVELNO �����ɷ���
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE cAMOUNT BETWEEN LOW AND HIGH AND cID=1) -- cID�� �ȿ��� �ִ� ������ ������ �Լ��� ������ֱ� ���ؼ� �ִ� ��
    WHERE cID=1;
    
SELECT * FROM CUSTOMER;

-- 5-1�� 5-3�� ��ġ�� CPOINT, CAMOUNT, LEVELNO�� �Ѳ����� �����ϱ�
-- cID�� �ȿ��� �ִ� ������ ������ �Լ��� ������ֱ� ���ؼ� �ִ� ��
UPDATE CUSTOMER SET cPOINT=cPOINT+(1000000*0.05),
                    cAMOUNT=cAMOUNT+1000000,
                    LEVELNO = ( SELECT L.LEVELNO �����ɷ���
                                FROM CUSTOMER C, CUS_LEVEL L
                                WHERE cAMOUNT+1000000 BETWEEN LOW AND HIGH AND cID=1)
    WHERE cID=1;
SELECT * FROM CUSTOMER;


-- 6. ��޺����
-- public ArrayList<CustomerDto> levelNameGetCustomers(String levelName)
-- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, �������� ���� �� ��
SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME,
    (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID=C.CID AND LEVELNO!=5) forLEVELUP
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO
    AND LEVELNAME='NORMAL';

-- 7.��ü���
-- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, �������� ���� �� ��
-- public ArrayList<CustomerDto> getCustomers()
SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME,
    (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID=C.CID AND LEVELNO!=5) forLEVELUP
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO;
    
-- 8. ȸ������(cTEL, cNAME �Է¹޾� INSERT)
-- public int insertCustomer(String cTel, String cName)
-- int insertCustomer(CustomerDto dto) �̷��� Dto������ �Ѱܵ� ok �Ű����� ���� ��� �̷��� �ѱ�� ��� �� ����
INSERT INTO CUSTOMER (cID, cTEL, cNAME)
    VALUES (CUSTOMER_SQ.NEXTVAL, '010-4455-5544', '����');
SELECT * FROM CUSTOMER;

-- 9. ��ȣ���� : public int updateCustomer(int cId, String cTel)
UPDATE CUSTOMER SET cTEL='010-3333-1111' WHERE cID=1;

-- 10. ȸ��Ż�� : public int deleteCustomer(String cTel)
DELETE FROM CUSTOMER WHERE cTEL='010-6666-6666';
COMMIT;
ROLLBACK;


