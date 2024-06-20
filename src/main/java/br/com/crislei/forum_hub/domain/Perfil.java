package br.com.crislei.forum_hub.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;

@Entity(name = "Perfil")
@Table(name= "perfil")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ="id")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToMany(mappedBy = "perfis")
    private Set<Usuario> usuarios = new HashSet<>();
}
