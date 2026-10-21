public class Concluinte extends Aluno{
    double notaFormacaoGeral, notaComponentEspecifico;
    boolean presente;

    public Concluinte(String nome, String matricula) {
        super(nome,matricula);
        this.setNotaFormacaoGeral(0);
        this.setNotaComponentEspecifico(0);
        this.presente = false;
    }

    public String toString() {
        return this.getNome() + " (" + this.getMatricula() + ") - CONCLUINTE";
    }

    public void cadastrarProva(double n1, double n2){
        this.setNotaFormacaoGeral(n1);
        this.setNotaComponentEspecifico(n2);
        this.presente = true;
    }
    public double calcularNota(){
        return ((this.notaComponentEspecifico*7)+(this.notaFormacaoGeral*3))/10;
    }
    public boolean regular(){
        return (presente && super.regular());
    }

    public void setNotaFormacaoGeral(double n){
        this.notaFormacaoGeral = n;
    }
    public void setNotaComponentEspecifico(double n){
        this.notaComponentEspecifico = n;
    }
}
