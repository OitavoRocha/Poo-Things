public class Gerente extends Funcionario {

    public Gerente(String nome, float salario, String dataAdmissao) {
        super(nome, salario, dataAdmissao);
    }

    @Override
    public void setReajuste(double reajuste) {
        super.setReajuste(reajuste + 0.05);
    }
    
    @Override
    public String toString() {
        return "Gerente { " + super.toString();
    }
}
