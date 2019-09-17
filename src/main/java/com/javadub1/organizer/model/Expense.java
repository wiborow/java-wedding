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
public class Expense implements IBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private ExpenseType expenseType;

    private Double expenseAmount;

    private String note;

    @ManyToOne
    private Wedding wedding;

    @OneToMany(mappedBy = "expense")
    private Set<Payment> payments;
}
