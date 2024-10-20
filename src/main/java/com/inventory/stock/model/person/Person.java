package com.inventory.stock.model.person;


import com.inventory.stock.model.invoice.Invoice;
import com.inventory.stock.model.person.add_ons.DocumentType;
import com.inventory.stock.model.person.add_ons.UserLogin;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Table(name = "person")

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long documentNumber;
    private DocumentType documentType;
    private String email;
    private String phone;
    private LocalDate registrationDate;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Invoice> invoices;

    @OneToOne(mappedBy = "person")
    private UserLogin userLogin;

}
