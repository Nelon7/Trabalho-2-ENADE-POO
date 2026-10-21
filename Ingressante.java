public class Ingressante extends Aluno{
    private int semIngresso;

    public Ingressante(String nome, String matricula, int semestre) {
        super(nome,matricula);
        this.setSemIngresso(semestre);
    }

    public String toString() {
        return this.getNome() + " (" + this.getMatricula() + ") - INGRESSANTE";
    }

    public int getSemIngresso() {
        return semIngresso;
    }
    public void setSemIngresso(int s){
        this.semIngresso = s;
    }
}
