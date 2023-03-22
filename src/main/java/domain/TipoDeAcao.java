package domain;

import jakarta.persistence.*;

@Entity
@Table(
        name = "tb_tipodeacao",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_id_tipodeacao",
                        columnNames = "id_tipodeacao"
                ),
                @UniqueConstraint(
                        name = "uk_nome_tipodeacao",
                        columnNames = "nome_tipodeacao"
                )
        }
)

public class TipoDeAcao {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_tipodeacao"
    )
    @SequenceGenerator(
            name = "seq_tipodeacao",
            sequenceName = "seq_tipodeacao",
            allocationSize = 1
    )

    @Column(name = "id_tipodeacao")
    private long id;

    @Column(name = "nome_tipodeacao")
    private String nome;

    public TipoDeAcao() {
    }

    public TipoDeAcao(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public TipoDeAcao setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public TipoDeAcao setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TipoDeAcao{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
