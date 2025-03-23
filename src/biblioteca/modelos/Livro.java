package biblioteca.modelos;

public class Livro extends Publicacao {
    private int volume;
    private String isbn;
    private String genero;
    private int numeroDeCapitulos;
    
    public int getVolume() {
        return volume;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getGenero() {
        return genero;
    }
    public int getNumeroDeCapitulos() {
        return numeroDeCapitulos;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setNumeroDeCapitulos(int numeroDeCapitulos) {
        this.numeroDeCapitulos = numeroDeCapitulos;
    }

    @Override
    public void exibeFichaLiteraria() {
        super.exibeFichaLiteraria(); // Chama o método da superclasse para exibir atributos comuns
        System.out.println("Gênero: " + genero);
        System.out.println("Volume: " + volume);
        System.out.println("ISBN: " + isbn);
        System.out.println("Número de capítulos: " + numeroDeCapitulos);
        System.out.println("Tipo de publicação: Livro");
    }
}
