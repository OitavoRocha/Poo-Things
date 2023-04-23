public class Funcionario {
    private String nome;
    private float salario;
    private String dataAdmissao;

    public Funcionario(String nome, float salario, String dataAdmissao) {
        this.nome = nome;
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
    }
    
    public void setReajuste( double reajuste ) {
        this.salario += this.salario * reajuste;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public String getNome() {
        return nome;
    }

    public float getSalario() {
        return salario;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "{ Nome: " + this.nome + "\n\tSalario: " + this.salario + "\n\tData de Admissao: " + this.dataAdmissao;
    }
}