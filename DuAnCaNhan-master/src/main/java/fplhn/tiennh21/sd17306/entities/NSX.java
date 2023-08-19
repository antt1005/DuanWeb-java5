package fplhn.tiennh21.sd17306.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "NSX")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NSX {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="Id")
    private UUID id;

    @Column(name="Ma")
    private String ma;

    @Column(name="Ten")
    private String ten;
}
