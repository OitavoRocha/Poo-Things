public class Analista extends Funcionario {

    public Analista(String nome, float salario, String dataAdmissao) {
        super(nome, salario, dataAdmissao);
    }
    
    @Override
    public String toString() {
        return "Analista { " + super.toString();
    }
}
