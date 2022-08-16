-- Q&A Dummy
INSERT INTO QNA (qno,qid,qsubject,qcontent,qhit,qgroup,qstep,qreplycheck)
	VALUES
    ((SELECT get_qna_seq('qno')) , 'son','가게 사장님과 컨택질문','광고 가능한가요3?',0,(SELECT qno FROM (SELECT MAX(qno)+1 AS qno FROM QNA) qna) ,0,0),
    ((SELECT get_qna_seq('qno')) , 'kang','질문이 있습니다1','광고 가능한가요3?',0,(SELECT qno FROM (SELECT MAX(qno)+1 AS qno FROM QNA) qna) ,0,0),
    ((SELECT get_qna_seq('qno')) , 'son','질문','예약 가능 한가요?',0,(SELECT qno FROM (SELECT MAX(qno)+1 AS qno FROM QNA) qna) ,0,0);
    
    

SELECT * FROM QNA;
SELECT * FROM QNA;


-- member Dummy
INSERT INTO MEMBER VALUES('aaa', '지코','1', '010-1234-1234','zico@naver.com','서울시 강남구 역삼동','남자','1992/09/14','zico.jpg');
INSERT INTO MEMBER VALUES('kang', '강동원','1', '010-4321-4321','kang@naver.com','서울시 강남구 역삼동','남자','1992/09/14','kang.jpg');
INSERT INTO MEMBER (MID, MNAME, MPW, MTEL, MEMAIL, MADDRESS, MGENDER,MBIRTH) VALUES ('carlos','김민우','111','010-9236-6409','max9236@naver.com','서울시 강남구 청담동','남자','1999/03/21');

commit;

