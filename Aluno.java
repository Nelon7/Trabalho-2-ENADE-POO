import java.util.ArrayList;

public class Aluno {
    private String nome,matricula;
    private boolean questionarioRespondido;

    public Aluno(String nome, String matricula) {
        this.setMatricula(matricula);
        this.setNome(nome);
        this.questionarioRespondido = false;
    }

    public String toString() {
        return this.nome + " (" + this.matricula + ")";
    }

    public boolean regular(){
        return questionarioRespondido;
    }
    public void cadastrarResposta(){
        this.questionarioRespondido = true;
    }

    public String getMatricula(){
        return this.matricula;
    }
    public String getNome() { return this.nome; }
    public void setMatricula(String m){
        this.matricula = m;
    }
    public void setNome(String n){
        this.nome = n;
    }
}
