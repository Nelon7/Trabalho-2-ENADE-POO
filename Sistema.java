import java.util.ArrayList;
import java.util.Objects;

public class Sistema {
    private ArrayList<Area> areas;
    private ArrayList<Curso> cursos;
    private ArrayList<Aluno> alunos;
    //verificar se é para ter arrays de curso e alunos em sistema


    public Sistema() {
        this.areas = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.alunos = new ArrayList<>();
    }

    public void cadastrarArea(Area area) {
        this.areas.add(area);
    }
    public void cadastrarCurso(Curso curso,Area area){
        area.adicionarCurso(curso);
        this.cursos.add(curso);
    }
    public void cadastrarAluno(Curso curso,Aluno aluno){
        curso.adicionarAluno(aluno);
        this.alunos.add(aluno);
    }

    public void listarResultados(int conceito){
        int e = 0;
        System.out.println("Cursos com conceito " + conceito + ": ");
        for(Area a : this.areas){
            for(Curso c : a.getCursos()){
                if(c.calcularConceito() == conceito){
                    System.out.println(c.toString() + " - Área: " + a.toString());
                    e = 1;
                }
            }
        }
        if(e == 0){
            System.out.println("Nenhum curso com conceito " + conceito + "foi encontrado.");
        }
    }
    public void listarResultados(String nomeArea){
        int e = 0;
        for(Area a : this.areas){
            if(Objects.equals(a.getNome(), nomeArea)){
                e = 1;
                if(a.getCursos().isEmpty()){
                    System.out.println("Nenhum curso na área " + nomeArea + "Foi encontrado");
                    return;
                }
                for(Curso c : a.getCursos()){
                    System.out.println(c.toString() +": " + c.calcularConceito());
                }
                break;
            }
        }
        if (e == 0){
            System.out.println("Nenhum curso na área " + nomeArea + "Foi encontrado");
        }
    }
    public void listarAlunosIrregulares(){
        for(Curso c : this.cursos){
            for(Aluno a : c.getAlunos()){
                if(a instanceof Ingressante i && !(i.regular())){
                    System.out.println(i.toString() + " - CURSO: " + c.toString());
                }
                else if (a instanceof Concluinte co && !(co.regular())) {
                    System.out.println(co.toString() + " - CURSO: " + c.toString());
                }
            }
        }
    }

    public ArrayList<Area> getAreas() {
        return areas;
    }
    public ArrayList<Curso> getCursos() {
        return cursos;
    }
    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }
}
