package Source.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import Source.Entidades.Funcionario;
import Source.Entidades.FuncionariosTerceirizados;

public class Programa {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        List<Funcionario> listaFuncionarios = new ArrayList<>();

        System.out.print("Entre o número de funcionarios: ");
        int funcionarios = scan.nextInt();

        for (int i = 0; i < funcionarios; i++){
            System.out.println("Funcionario #" + (i+1) + ":");
            char resposta;

            // Loop para garantir que a entrada seja 'S' ou 'N'
            do {
                System.out.print("Funcionario terceirizado (S/N)? ");
                resposta = scan.next().toUpperCase().charAt(0);
                if (resposta != 'S' && resposta != 'N') {
                    System.out.println("Resposta inválida. Por favor, digite S ou N.");
                }
            } while (resposta != 'S' && resposta != 'N');
            scan.nextLine(); // Limpar o buffer de entrada

            System.out.print("Nome: ");
            String nome = scan.nextLine();
            System.out.print("Horas: ");
            int horas = scan.nextInt();
            System.out.print("Valor por hora: ");
            double valorHora = scan.nextDouble();

            if(resposta == 'S'){
                System.out.print("Cobrança adicional: ");
                double cobrancaAdicional = scan.nextDouble();
                Funcionario funcionario = new FuncionariosTerceirizados(nome, horas, valorHora, cobrancaAdicional);
                listaFuncionarios.add(funcionario);
            } else {
                Funcionario funcionario = new Funcionario(nome, horas, valorHora);
                listaFuncionarios.add(funcionario);
            }
        }

        System.out.println("Pagamentos: ");
        for(Funcionario listaPagamento : listaFuncionarios){
            double pagamento = listaPagamento.pagamento();
            System.out.println(listaPagamento.getNome() + "- R$ " + pagamento);
        }

        scan.close();
    }
}
