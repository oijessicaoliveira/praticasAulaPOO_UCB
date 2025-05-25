package biblioteca.modelos;

public abstract class PublicacaoDigital extends Publicacao {
    private int tamanhoEmMB; // Primitivo int será 0 por padrão

    public int getTamanhoEmMB() {
        return tamanhoEmMB;
    }

    public void setTamanhoEmMB(int tamanhoEmMB) {
        if (tamanhoEmMB <= 0) throw new IllegalArgumentException("Tamanho do arquivo (MB) deve ser maior que zero.");
        this.tamanhoEmMB = tamanhoEmMB;
    }

    @Override
    protected void exibeFichaEspecifica() {
        System.out.println("Tamanho do arquivo: " + (tamanhoEmMB == 0 ? "N/A" : tamanhoEmMB + " MB"));
    }

    public abstract void baixar();
}