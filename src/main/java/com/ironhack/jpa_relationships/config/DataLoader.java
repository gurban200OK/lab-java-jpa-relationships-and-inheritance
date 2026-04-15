package com.ironhack.jpa_relationships.config;

import com.ironhack.jpa_relationships.entity.*;
import com.ironhack.jpa_relationships.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(GuestRepository guestRepository,
                               AssociationRepository associationRepository,
                               DivisionRepository divisionRepository,
                               ContactRepository contactRepository,
                               EventRepository eventRepository) {
        return args -> {
            Name contactName=new Name(Salutation.Dr, "Mike", "A.","Mentzer");
            Contact contact=new Contact("Ironhack Tech", "Lead Developer", contactName);
            contactRepository.save(contact);

            Association association=new Association();
            association.setName("Nurse Association");
            associationRepository.save(association);

            List<Division> divisions=new ArrayList<>();

            for(int i=1;i<7;i++){
                Division division=new Division();
                division.setName("Division"+i);
                division.setDistrict("District"+i);
                division.setAssociation(association);

                List<Member> members=new ArrayList<>();
                Member m1=new Member();
                m1.setName("Member"+i+"A");
                m1.setMemberStatus(MemberStatus.ACTIVE);
                m1.setRenewalDate(LocalDate.now().plusDays(30));

                Member m2=new Member();
                m2.setName("Member"+i+"B");
                m2.setMemberStatus(MemberStatus.LAPSED);
                m2.setRenewalDate(LocalDate.now().minusDays(30));
                members.add(m1);
                members.add(m2);
                division.setMembers(members);
                division.setPresident(m1);

                divisions.add(division);
            }
            association.setDivisions(divisions);
            divisionRepository.saveAll(divisions);

            Guest g1=new Guest();
            g1.setName("John");
            g1.setStatus(GuestStatus.ATTENDING);

            Guest g2=new Guest();
            g2.setName("Jane");
            g2.setStatus(GuestStatus.NOT_ATTENDING);

            Guest g3=new Guest();
            g3.setName("Bob");
            g3.setStatus(GuestStatus.NOT_ATTENDING);

            guestRepository.saveAll(List.of(g1,g2,g3));

            Conference conference=new Conference();
            conference.setTitle("Tech Conference");
            conference.setLocation("Baku");
            conference.setDate(LocalDate.now().plusDays(10));
            conference.setDuration(120);
            conference.setGuests(List.of(g1,g2,g3));

            Speaker s1=new Speaker("Speaker 1",30);
            conference.setSpeakers(List.of(s1));

            eventRepository.save(conference);
            System.out.println("Sample data loaded succesfully!");
        };
    }
}
