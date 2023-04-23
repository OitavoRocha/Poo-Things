public class Tecnico extends Funcionario {

    public Tecnico(String nome, float salario, String dataAdmissao) {
        super(nome, salario, dataAdmissao);
    }

    @Override
    public String toString() {
        return "Tecnico { " + super.toString();
    }
}
