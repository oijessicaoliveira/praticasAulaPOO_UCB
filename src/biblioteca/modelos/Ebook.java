package biblioteca.modelos;

public class Ebook extends PublicacaoDigital {

    private String formato; // e.g. "PDF", "EPUB", "MOBI"...

    public String getFormato() {
        return formato;
    }
    public void setFormato(String formato) {
        this.formato = formato;
    }

    // Como PublicacaoDigital tem um método abstrato "baixar()",
    // somos OBRIGADOS a implementar aqui:
    @Override
    public void baixar() {
        System.out.println("Baixando e-book " + getTitulo() + " em formato " + this.formato);
    }

    // Podemos também sobrescrever exibeFichaLiteraria se quisermos
    // algo ainda mais específico que a implementação de PublicacaoDigital.
    // Se não sobrescrevermos, fica valendo a de PublicacaoDigital.

    /*
    @Override
    public void exibeFichaLiteraria() {
        super.exibeFichaLiteraria();
        System.out.println("Formato do ebook: " + this.formato);
    }
    */
}
