package biblioteca.modelos;

public abstract class Publicacao {
    private String titulo;
    private String autor;
    private String editora;
    private int numeroDePaginas;

    private Avaliacao avaliacao = new Avaliacao();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        if (numeroDePaginas <= 0) {
            throw new IllegalArgumentException("Número de páginas deve ser maior que zero.");
        }
        this.numeroDePaginas = numeroDePaginas;
    }

    public void avalia(double nota) {
        avaliacao.adicionarNota(nota);
    }

    public void avalia(int nota) {
        avalia((double) nota);
    }

    public void avalia(double[] notas) {
        for (double nota : notas) {
            avalia(nota);
        }
    }

    public void avaliaComValidacao(double nota) throws IllegalArgumentException {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("Nota inválida. Informe valor entre 0 e 10.");
        }
        avalia(nota);
    }

    public double retornaMedia() {
        return avaliacao.media();
    }

    public void exibeFichaCompleta() {
        exibeFichaBasica();
        System.out.println("Tipo: " + getTipo()); // Adicionado
        exibeFichaEspecifica();
    }

    private void exibeFichaBasica() {
        System.out.println("\n--- Ficha da Publicação ---");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Editora: " + editora);
        System.out.println("Número de páginas: " + numeroDePaginas);
    }

    protected abstract void exibeFichaEspecifica();
    public abstract String getTipo();
}