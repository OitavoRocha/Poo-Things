public class Empresa {
    private String nome;
    private String cnpj;
    private Funcionario funcionarios[];

    public Empresa(String nome, String cnpj, int numeroFuncionarios) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.funcionarios = new Funcionario[numeroFuncionarios];
    }
    
    void inserirFuncionario( Funcionario f ) {
        int i;
        for( i = 0 ; i<funcionarios.length ; i++ )
                if( funcionarios[i] == null ) {
                    funcionarios[i] = f;
                    return;
                }
        
        Funcionario novaLista[] = new Funcionario[funcionarios.length * 2];

        for( i = 0 ; i<funcionarios.length ; i++ )
            novaLista[i] = funcionarios[i];
        
        novaLista[i] = f;
        funcionarios = novaLista;
    }
    
    void aumentarSalario() {
        for( int i = 0 ; i<funcionarios.length ; i++ ) {
            if( funcionarios[i] == null ) 
                return;
            funcionarios[i].setReajuste(0.1);
        }
    }

    @Override
    public String toString() {
        System.out.println("Empresa: { Nome: " + this.nome + "\n\tCNPJ: " + this.cnpj + "\n\tFuncionarios: \n");
        for( int i = 0 ; i < this.funcionarios.length ; i++ ) {
            if( this.funcionarios[i] == null )
                return "\n";
            System.out.println(funcionarios[i].toString());
        }
        return "\n";
    }
}