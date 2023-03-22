package domain;

import jakarta.persistence.*;

@Entity
@Table(
        name = "tb_advogado",
        uniqueConstraints = {

                @UniqueConstraint(
                name = "uk_id_advogado",
                columnNames = "id_advogado"
        ),
                @UniqueConstraint(
                        name = "uk_numerooab_advogado",
                        columnNames = "numerooab_advogado"
                )

        }


)

public class Advogado {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_advogado"
    )
    @SequenceGenerator(
            name = "seq_advogado",
            sequenceName = "seq_advogado",
            allocationSize = 1
    )

    @Column(name = "id_advogado")
    private long id;

    @Column(name = "nome_advogado")
    private String nome;

    @Column(name = "numerooab_advogado")
    private String numeroOAB;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.DETACH
    )

    @JoinColumn(
            name = "id_estado",
            referencedColumnName = "id_estado",
            foreignKey = @ForeignKey(name = "fk_id_estado", value = ConstraintMode.CONSTRAINT)
    )
    private Estado estado;

    public Advogado() {
    }

    public Advogado(long id, String nome, String numeroOAB, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.numeroOAB = numeroOAB;
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public Advogado setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Advogado setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getNumeroOAB() {
        return numeroOAB;
    }

    public Advogado setNumeroOAB(String numeroOAB) {
        this.numeroOAB = numeroOAB;
        return this;
    }

    public Estado getEstado() {
        return estado;
    }

    public Advogado setEstado(Estado estado) {
        this.estado = estado;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Advogado{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", numeroOAB='").append(numeroOAB).append('\'');
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }


}
