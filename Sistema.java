import java.util.ArrayList;

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

    }
    public void listarResultados(String nomeArea){

    }
    public void listarAlunosIrregulares(){

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
