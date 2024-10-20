package com.inventory.stock.model.person.add_ons;


import com.inventory.stock.model.person.Person;
import com.inventory.stock.model.sale.Sale;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "user_login")

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private Role role;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToMany(mappedBy = "worker", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Sale> sales;

}
