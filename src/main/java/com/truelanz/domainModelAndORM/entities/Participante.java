package com.truelanz.domainModelAndORM.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_participante")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String nome;
    private String email;

    @ManyToMany 
    @JoinTable(name = "tb_participante_atividade", // classe intermediária que será criada
                joinColumns = @JoinColumn(name = "participante_id"), // foreign key da classe onde estou mapeando
                inverseJoinColumns = @JoinColumn(name = "atividade_id")) // foreign key da classe que estou relacionando
                                                                                
    @Setter(AccessLevel.NONE)
    private Set<Atividade> atividades = new HashSet<>();
    
}
