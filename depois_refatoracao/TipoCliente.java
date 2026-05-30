public enum TipoCliente {

    COMUM(0.05),
    ESPECIAL(0.10),
    VIP(0.15);

    private final double desconto;

    TipoCliente(double desconto) {
        this.desconto = desconto;
    }

    public double getDesconto() {
        return desconto;
    }
}
