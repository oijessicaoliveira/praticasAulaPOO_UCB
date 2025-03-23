package biblioteca.modelos;

public class Livro extends Publicacao {
    private int volume;
    private String isbn;
    private int numeroDeCapitulos;
    
    public int getVolume() {
        return volume;
    }
    public String getIsbn() {
        return isbn;
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
    public void setNumeroDeCapitulos(int numeroDeCapitulos) {
        this.numeroDeCapitulos = numeroDeCapitulos;
    }
}
