package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.entity.MemberAuth;
import com.example.demo.entity.VueBoard;
import com.example.demo.repository.VueBoardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueBoardServiceImpl implements  VueBoardService {
    static final Logger log = LoggerFactory.getLogger(VueBoardServiceImpl.class);

    @Autowired
    private VueBoardRepository repository;

    @Override
    public void register(VueBoard board) throws Exception {
        repository.create(board);
    }
    @Override
    public VueBoard read(Long boardNo) throws Exception {
        log.info("VueBoardService read(boardNo): " + boardNo);
        return repository.read(boardNo);
    }
    @Override
    // 전달되는 정보가 board
    public void modify(VueBoard board) throws Exception {
        log.info("VueBoardService modify(board): " + board);
        repository.update(board);
    }
    @Override
    public void remove(Long boardNo) throws Exception {
        log.info("VueBoardService remove(boardNo): " + boardNo);
        repository.delete(boardNo);
    }
    @Override
    public List<VueBoard> list() throws Exception {
        return repository.list();
    }
}

//    @Override
//    public void register(Member member) throws Exception {
//        Member memEntity = new Member();
//        memEntity.setUserId(member.getUserId());
//        memEntity.setUserPw(member.getUserPw());
//        memEntity.setUserName(member.getUserName());
//        memEntity.setJob(member.getJob());
//        //  MemberAuth 일반사용자 를 setAuth
//        MemberAuth memberAuth = new MemberAuth();
//        memberAuth.setAuth("ROLE_MEMBER");
//
//        memEntity.addAuth(memberAuth);
//
//        repository.save(memEntity);
//
//        member.setUserNo(memEntity.getUserNo());
//    }