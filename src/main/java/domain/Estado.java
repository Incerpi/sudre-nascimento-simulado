package domain;

import jakarta.persistence.*;

@Entity
@Table(
		name = "tb_estado",
		uniqueConstraints = {
				@UniqueConstraint(
						name = "uk_nome_estado",
						columnNames = "nome_estado"
				),
				@UniqueConstraint(
						name = "uk_sigla_estado",
						columnNames = "sigla_estado"
				)
		}

)

public class Estado {

	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "seq_estado"
	)
	@SequenceGenerator(
			name = "seq_estado",
			sequenceName = "seq_estado",
			allocationSize = 1
	)

	@Column(name = "id_estado")
	private int id;
	@Column(name = "nome_estado")
	private String nome;
	@Column(name = "sigla_estado")
	private String sigla;

	public Estado() {
	}

	public Estado(int id, String nome, String sigla) {
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
	}

	public Estado(String showInputDialog, String showInputDialog1) {

	}

	public int getId() {
		return id;
	}

	public Estado setId(int id) {
		this.id = id;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public Estado setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public String getSigla() {
		return sigla;
	}

	public Estado setSigla(String sigla) {
		this.sigla = sigla;
		return this;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Estado{");
		sb.append("id=").append(id);
		sb.append(", nome='").append(nome).append('\'');
		sb.append(", sigla='").append(sigla).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
