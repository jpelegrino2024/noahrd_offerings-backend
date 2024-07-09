package com.julioluis.offeringsbackend;

import com.julioluis.offeringsbackend.entities.*;
import com.julioluis.offeringsbackend.repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class NoahrdOfferingsBackendApplicationTests {

    @Autowired
    private SpentRepository spentRepository;
    @Autowired
    private SpentTypeRepository spentTypeRepository;
    @Autowired
    private OfferingRepository offeringRepository;
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private MemberRepository memberRepository;


    @Test
    void contextLoads() {
    }

    @Test
    public void createSpentType() {
        SpentType spentType = new SpentType();
        spentType.setName("Fiesta");

        spentTypeRepository.save(spentType);
    }

    @Test
    public void createOffering() {
        Offering offering = new Offering();
        offering.setAmount(BigDecimal.valueOf(6560));
        offering.setComment("Ofrenda depositada");

        Settlement settlement = new Settlement();
        settlement.setTransactionDate(LocalDate.now());

        offering.addSettlement(settlement);

        offeringRepository.save(offering);
    }

    @Test
    public void createSpent() {
        Spent spent = new Spent();

        SpentType spentType = spentTypeRepository.findById(1L).get();

        spent.setAmount(BigDecimal.valueOf(2000));
        spent.setComment("Curso de Torah con el Rabino Ariel Groisman");

        Settlement settlement = new Settlement();
        settlement.setTransactionDate(LocalDate.now());

        spent.addSettlement(settlement);
        spent.setSpentType(spentType);

        spentRepository.save(spent);

    }

    @Test
    public void createRol() {
        Rol rol = new Rol();
        rol.setRolName("TREASURE");

        rolRepository.save(rol);
    }

    @Test
    public void createAuthority() {
        Authority authority = new Authority();
        authority.setAuthorityName("VIEW OFFERING");

        authorityRepository.save(authority);
    }

    @Test
    public void assignAuthorityToRol() {
        Rol rol = rolRepository.findById(4L).orElse(null);
        Authority authority = authorityRepository.findById(1L).orElseThrow();
        Authority authority2 = authorityRepository.findById(2L).orElseThrow();

        Authority authority3 = authorityRepository.findById(3L).orElseThrow();
        Set<Authority> authorities = new HashSet<>();
//        authorities.add(authority);
//        authorities.add(authority2);
        authorities.add(authority3);

        rol.setAuthorities(authorities);

        rolRepository.save(rol);
    }

    @Test
    public void createMember() {
        Member member = new Member();
        member.setFirstName("Juan");
        member.setLastName("Martinez");
        member.setEmail("jmartinez@gmail.com");
        Rol rol = rolRepository.findById(1L).orElseThrow();
        member.setRol(rol);

        memberRepository.save(member);
    }


    @Test
    public void testGetMemeberByEmail() {
        Member member = memberRepository.getByEmail("jmartinez@gmail.com").orElse(null);
        System.out.println("*********************************************");
        System.out.println(member.getFirstName() +" "+ member.getLastName());
    }


}
