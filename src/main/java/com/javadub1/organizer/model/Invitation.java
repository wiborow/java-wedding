package com.javadub1.organizer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invitation implements IBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private AddressLocation address;

    @OneToMany(mappedBy = "invitation", fetch = FetchType.EAGER)
    private Set<Person> peopleInvited;

    @OneToMany
    private Set<Person> namesOnInvitation;

    @Enumerated(value = EnumType.STRING)
    private InvitationType invitationType;

    private boolean sent;  // zaproszony
    private boolean verified;

    // stworzy się dodatkowa tabela dla osób potwierdzonych
    // idenytfikator zaproszenia i identyfikator osoby
    @OneToMany
    private Set<Person> verifiedPeople; // ile osób potwierdził

    @ManyToOne
    private Wedding wedding;
}