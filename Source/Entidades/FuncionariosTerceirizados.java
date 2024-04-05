package Source.Entidades;

import java.util.List;

@SuppressWarnings("unused")
public class FuncionariosTerceirizados extends Funcionario {
    private Double cobrancaAdicional;

    public FuncionariosTerceirizados(){
        super();
    }

    public FuncionariosTerceirizados(String nome, Integer horas, Double valorPorHora, Double cobrancaAdicional) {
        super(nome, horas, valorPorHora);
        this.cobrancaAdicional = cobrancaAdicional;
    }

    
    @Override
    public double pagamento(){
        return super.pagamento() + cobrancaAdicional * 1.1;
    }
}
