package biblioteca.modelos;
import biblioteca.interfaces.Digitalizavel;

public class Livro extends Publicacao implements Digitalizavel {
    private int volume;
    private String isbn;
    private String genero;
    private int numeroDeCapitulos;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume <= 0) throw new IllegalArgumentException("Volume inválido.");
        this.volume = volume;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNumeroDeCapitulos() {
        return numeroDeCapitulos;
    }

    public void setNumeroDeCapitulos(int numeroDeCapitulos) {
        if (numeroDeCapitulos <= 0) throw new IllegalArgumentException("Número de capítulos inválido.");
        this.numeroDeCapitulos = numeroDeCapitulos;
    }

    @Override
    protected void exibeFichaEspecifica() {
        System.out.println("Tipo: Livro");
        System.out.println("Gênero: " + genero);
        System.out.println("Volume: " + volume);
        System.out.println("ISBN: " + isbn);
        System.out.println("Capítulos: " + numeroDeCapitulos);
    }

    @Override
    public String getTipo() {
        return "Livro";
    }

    @Override
    public void geraVersaoDigital() {
        System.out.println("Versão digital do livro gerada com sucesso.");
    }
}