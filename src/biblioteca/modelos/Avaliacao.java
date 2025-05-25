package biblioteca.modelos;

public class Avaliacao {
    private double somaNotas;
    private int totalNotas;

    public void adicionarNota(double nota) {
        somaNotas += nota;
        totalNotas++;
    }

    public double media() {
        return totalNotas == 0 ? 0 : somaNotas / totalNotas;
    }
}