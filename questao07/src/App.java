public class App {
    public static void main(String[] args) {
        Empresa emp = new Empresa("Ararazu", "123456789", 5);
        
        emp.inserirFuncionario(new Gerente("Matheus", 1000, "23/01"));
        emp.inserirFuncionario(new Analista("Sandra", 100, "02/02"));
        emp.inserirFuncionario(new Tecnico("Otavio", 500, "15/06"));
        
        System.out.println(emp.toString());
        
        emp.aumentarSalario();
        
        System.out.println("+-----------------+\n");
        System.out.println(emp.toString());
    }
}