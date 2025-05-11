package biblioteca.modelos;

public class Ebook extends PublicacaoDigital {
    private String formato;

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    @Override
    protected void exibeFichaEspecifica() {
        super.exibeFichaEspecifica();
        System.out.println("Formato: " + formato);
    }

    @Override
    public String getTipo() {
        return "Ebook";
    }

    @Override
    public void baixar() {
        System.out.println("Baixando e-book: " + getTitulo() + " no formato " + formato);
    }
}