package com.ironhack.jpa_relationships.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 50)
    private String name;
    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus;
    private LocalDate renewalDate;

    public Member() {
    }

    public Member(String name, MemberStatus memberStatus, LocalDate renewalDate) {
        this.name = name;
        this.memberStatus = memberStatus;
        this.renewalDate = renewalDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MemberStatus getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(MemberStatus memberStatus) {
        this.memberStatus = memberStatus;
    }

    public LocalDate getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(LocalDate renewalDate) {
        this.renewalDate = renewalDate;
    }
}
