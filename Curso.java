import java.util.ArrayList;

public class Curso {
    private String codigo,nome;
    private ArrayList<Aluno> alunos;

    public Curso(String codigo, String nome){
        this.setCodigo(codigo);
        this.setNome(nome);
        this.alunos = new ArrayList<>();
    }

    public String toString() {
        return this.nome + " (" + this.codigo + ")";
    }

    public void adicionarAluno(Aluno aluno){
        this.alunos.add(aluno);
    }

    public double calcularMedia(){
        double soma = 0;
        int i = 0;
        for(Aluno a : alunos){
            if(a instanceof Concluinte c){
                soma += c.calcularNota();
                i+=1;
            }
        }
        if(i==0) return 0;
        return soma/i;
    }
    public int calcularConceito(){
        double media = calcularMedia();

        if(media<2){
            return 1;
        } 
        else if (media<4) {
            return 2;
        }
        else if (media<6) {
            return 3;
        }
        else if (media<8) {
            return 4;
        }
        else{
            return 5;
        }
    }

    public ArrayList<Ingressante> ingressantes(){
        ArrayList<Ingressante> ing = new ArrayList<>();
        for(Aluno a : alunos){
            if(a instanceof Ingressante i){
                ing.add(i);
            }
        }
        return ing;
    }
    public ArrayList<Ingressante> ingressantes(int semestre){
        ArrayList<Ingressante> ing = new ArrayList<>();
        for(Aluno a : alunos){
            if(a instanceof Ingressante i && i.getSemIngresso() == semestre){
                ing.add(i);
            }
        }
        return ing;
    }

    public void setCodigo(String c){
        this.codigo = c;
    }
    public void setNome(String n){
        this.nome = n;
    }
    public String getCodigo() {
        return codigo;
    }
    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }
}
