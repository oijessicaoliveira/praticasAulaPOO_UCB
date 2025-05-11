package biblioteca.modelos;

public abstract class PublicacaoDigital extends Publicacao {
    private int tamanhoEmMB;

    public int getTamanhoEmMB() {
        return tamanhoEmMB;
    }

    public void setTamanhoEmMB(int tamanhoEmMB) {
        if (tamanhoEmMB <= 0) throw new IllegalArgumentException("Tamanho inválido.");
        this.tamanhoEmMB = tamanhoEmMB;
    }

    @Override
    protected void exibeFichaEspecifica() {
        System.out.println("Tipo: Publicação Digital");
        System.out.println("Tamanho do arquivo: " + tamanhoEmMB + " MB");
    }

    public abstract void baixar();
}