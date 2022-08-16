-- final DUMMY





































-- 민우
INSERT INTO QNA (qno,qid,qsubject,qcontent,qhit,qgroup,qstep,qreplycheck)
	VALUES
    ((SELECT get_qna_seq('qno')) , 'son','가게 사장님과 컨택질문','광고 가능한가요3?',0,(SELECT qno FROM (SELECT MAX(qno)+1 AS qno FROM QNA) qna) ,0,0),
    ((SELECT get_qna_seq('qno')) , 'kang','질문이 있습니다1','광고 가능한가요3?',0,(SELECT qno FROM (SELECT MAX(qno)+1 AS qno FROM QNA) qna) ,0,0),
    ((SELECT get_qna_seq('qno')) , 'son','질문','예약 가능 한가요?',0,(SELECT qno FROM (SELECT MAX(qno)+1 AS qno FROM QNA) qna) ,0,0);

INSERT INTO MEMBER VALUES('aaa', '지코','1', '010-1234-1234','zico@naver.com','서울시 강남구 역삼동','남자','1992/09/14','zico.jpg');
INSERT INTO MEMBER VALUES('kang', '강동원','1', '010-4321-4321','kang@naver.com','서울시 강남구 역삼동','남자','1992/09/14','kang.jpg');
INSERT INTO MEMBER (mid, mname, mpw, mtel, memail, maddress, mgender,mbirth) VALUES ('carlos','김민우','111','010-9236-6409','max9236@naver.com','서울시 강남구 청담동','남자','1999/03/21');


-- 희석
INSERT INTO ADMIN (ano, aid, apw, aemail, aname, atel, alevel)
    VALUES((SELECT get_admin_seq('ano')), 'moan125', '1234', 'moan125@naver.com', '문희석', '010-9999-1234', 2);
INSERT INTO ADMIN (ano, aid, apw, aemail, aname, atel, alevel)
    VALUES((SELECT get_admin_seq('ano')), 'aaa', '1234', 'lee@naver.com', '이진우', '010-1111-1234', 1);
INSERT INTO ADMIN (ano, aid, apw, aemail, aname, atel, alevel)
    VALUES((SELECT get_admin_seq('ano')), 'bbb', '1234', 'kim@naver.com', '김민우', '010-2222-1234', 1);
INSERT INTO ADMIN (ano, aid, apw, aemail, aname, atel, alevel)
    VALUES((SELECT get_admin_seq('ano')), 'ccc', '1234', 'ryu@naver.com', '류지환', '010-3333-1234', 1);
INSERT INTO ADMIN (ano, aid, apw, aemail, aname, atel, alevel)
    VALUES((SELECT get_admin_seq('ano')), 'ddd', '1234', 'hong@naver.com', '홍길동', '010-4444-1234', 0);
INSERT INTO ADMIN (ano, aid, apw, aemail, aname, atel, alevel)
    VALUES((SELECT get_admin_seq('ano')), 'eee', '1234', 'kimkim@naver.com', '김럭비', '010-4444-1234', 0);
INSERT INTO ADMIN (ano, aid, apw, aemail, aname, atel, alevel)
    VALUES((SELECT get_admin_seq('ano')), 'fff', '1234', 'parkpark@naver.com', '박농구', '010-4444-1234', 0);
    
commit;