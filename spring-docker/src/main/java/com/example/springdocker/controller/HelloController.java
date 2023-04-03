package com.example.springdocker.controller;

import com.example.springdocker.service.MemberService;
import com.example.springdocker.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/*")
// @CrossOrigin(origins = "*", allowedHeaders = "*")
public class HelloController {

    @Autowired
    MemberService memberService;

    @GetMapping("/")
    public String hello() {
        return "Hello Docker3!!!";
    }

    @GetMapping("/members")
    public List<MemberVO> selectListMembers() {
        return memberService.selectAllMembers();
    }

    @PostMapping("/add-member")
    public String insertMember(@RequestBody MemberVO vo) {
        memberService.insertMember(vo);
        return "Ok";
    }
}
