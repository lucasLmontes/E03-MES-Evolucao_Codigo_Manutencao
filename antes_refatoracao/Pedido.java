public class Pedido {

    public String nomeCliente;
    public String cpfCliente;
    public double produto1;
    public double produto2;
    public double produto3;
    public int tipoCliente;

    public void processarPedido() {
        double total = produto1 + produto2 + produto3;

        if (tipoCliente == 1) {
            total = total - (total * 0.05);
        } else if (tipoCliente == 2) {
            total = total - (total * 0.10);
        } else if (tipoCliente == 3) {
            total = total - (total * 0.15);
        }

        System.out.println("Cliente: " + nomeCliente);
        System.out.println("CPF: " + cpfCliente);
        System.out.println("Produto 1: R$ " + produto1);
        System.out.println("Produto 2: R$ " + produto2);
        System.out.println("Produto 3: R$ " + produto3);
        System.out.println("Total da compra: R$ " + total);
    }
}
