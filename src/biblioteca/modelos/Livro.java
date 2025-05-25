package biblioteca.modelos;
import biblioteca.interfaces.Digitalizavel;

public class Livro extends Publicacao implements Digitalizavel {
    private int volume;
    private String isbn;
    private String genero;
    private int numeroDeCapitulos;

    public Livro() {
        // Construtor padrão
    }

    // Construtor completo pode ser útil, mas não é estritamente necessário para Gson se houver setters
    public Livro(String titulo, String autor, String editora, int numeroDePaginas,
                 String genero, int volume, String isbn, int numeroDeCapitulos) {
        setTitulo(titulo);
        setAutor(autor);
        setEditora(editora);
        setNumeroDePaginas(numeroDePaginas);
        setGenero(genero);
        setVolume(volume);
        setIsbn(isbn);
        setNumeroDeCapitulos(numeroDeCapitulos);
    }


    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume <= 0) throw new IllegalArgumentException("Volume do livro deve ser maior que zero.");
        this.volume = volume;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn; // ISBN pode ser opcional ou ter validações mais complexas
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
        if (numeroDeCapitulos <= 0) throw new IllegalArgumentException("Número de capítulos do livro deve ser maior que zero.");
        this.numeroDeCapitulos = numeroDeCapitulos;
    }

    @Override
    protected void exibeFichaEspecifica() {
        System.out.println("Gênero: " + (genero == null || genero.isEmpty() ? "N/A" : genero));
        System.out.println("Volume: " + (volume == 0 ? "N/A" : volume));
        System.out.println("ISBN: " + (isbn == null || isbn.isEmpty() ? "N/A" : isbn));
        System.out.println("Capítulos: " + (numeroDeCapitulos == 0 ? "N/A" : numeroDeCapitulos));
    }

    @Override
    public String getTipo() {
        return "Livro";
    }

    @Override
    public void geraVersaoDigital() {
        System.out.println("Versão digital do livro '" + getTitulo() + "' gerada com sucesso.");
    }
}