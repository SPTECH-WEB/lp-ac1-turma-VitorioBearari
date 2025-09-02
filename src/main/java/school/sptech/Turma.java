package school.sptech;

public class Turma {
    private String nome;
    private Double mensalidade;
    private Integer qtdAluno;
    private Boolean ativa;

    public Turma(String nome, Double mensalidade){
        this.nome = nome;
        this.mensalidade = mensalidade;
        qtdAluno = 0;
        ativa = true;
    }

    public void matricular(Integer qtd){
        if(qtd != null && qtd > 0 && ativa){
            qtdAluno += qtd;
        }
    };

    public Integer cancelar(Integer qtd){
        if(qtd != null && qtd > 0 && qtd <= qtdAluno && ativa){
            return qtdAluno -= qtd;
        } else {
            return null;
        }
    };

    public Integer desativar(){
        if(ativa){
            Integer qtdAlunosAntigo = qtdAluno;
            qtdAluno = 0;
            ativa = false;
            return qtdAlunosAntigo;
        } else {
            return null;
        }
    };

    public void transferir(Turma destino, Integer qtdATransferir){
        if(destino != null && qtdATransferir != null && qtdATransferir > 0 && destino.ativa && qtdAluno >= qtdATransferir && ativa){
            destino.qtdAluno += qtdATransferir;
            qtdAluno -= qtdATransferir;
        }
    };

    public Boolean reajustarMensalidade(Double reajuste){
        if(reajuste != null && reajuste > 0){
            mensalidade *= (1+reajuste);
            return true;
        } else {
            return false;
        }
    }

    public String getNome() {
        return nome;
    }

    public Double getMensalidade() {
        return mensalidade;
    }

    public Integer getQtdAluno() {
        return qtdAluno;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
