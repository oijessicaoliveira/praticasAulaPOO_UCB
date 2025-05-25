package biblioteca.modelos;

public class Ebook extends PublicacaoDigital {
    private String formato;

    public Ebook() {
        // Construtor padrão
    }

    public Ebook(String titulo, String autor, String editora, int numeroDePaginas,
                 int tamanhoEmMB, String formato) {
        setTitulo(titulo);
        setAutor(autor);
        setEditora(editora);
        setNumeroDePaginas(numeroDePaginas);
        setTamanhoEmMB(tamanhoEmMB); // Chama o setter da superclasse PublicacaoDigital
        setFormato(formato);
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    @Override
    protected void exibeFichaEspecifica() {
        super.exibeFichaEspecifica(); // Chama o método da PublicacaoDigital para exibir tamanhoMB
        System.out.println("Formato: " + (formato == null || formato.isEmpty() ? "N/A" : formato));
    }

    @Override
    public String getTipo() {
        return "Ebook";
    }

    @Override
    public void baixar() {
        System.out.println("Baixando e-book: " + getTitulo() + " no formato " + (formato == null || formato.isEmpty() ? "[formato desconhecido]" : formato));
    }
}