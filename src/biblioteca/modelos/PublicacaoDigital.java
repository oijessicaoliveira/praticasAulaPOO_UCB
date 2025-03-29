package biblioteca.modelos;

public abstract class PublicacaoDigital extends Publicacao {

    // Atributo característico de publicações digitais
    protected int tamanhoEmMB;

    // Getter e Setter para o tamanho do arquivo digital
    public int getTamanhoEmMB() {
        return tamanhoEmMB;
    }
    public void setTamanhoEmMB(int tamanhoEmMB) {
        this.tamanhoEmMB = tamanhoEmMB;
    }

    /*
     * Método abstrato: toda "PublicacaoDigital" precisa saber
     * como será feito o "download" (mas cada subclasse pode
     * implementar de maneira diferente).
     */
    public abstract void baixar();

    /*
     * Podemos sobrescrever alguns métodos de Publicacao se quisermos,
     * mas não somos obrigados. Vou dar um exemplo de sobrescrita simples
     * que mostra que agora a "ficha literária" exibe também o tamanho do arquivo.
     */
    @Override
    public void exibeFichaLiteraria() {
        // Chama a exibição base da classe pai (exibe título, autor, etc.)
        super.exibeFichaLiteraria();
        // Acrescenta detalhes da publicação digital
        System.out.println("Tamanho do arquivo: " + this.tamanhoEmMB + " Mb");
    }
}
