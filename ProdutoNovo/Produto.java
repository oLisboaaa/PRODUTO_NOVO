package ProdutoNovo;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

class CadastroProduto {
    private String nome;
    private Date dataFab;
    private Date dataVal;
    private double precoVenda;

    // Construtor modificado para receber todos os dados
    public CadastroProduto(String nome, Date dataFab, double precoVenda) {
        this.nome = nome;
        this.dataFab = dataFab;
        this.precoVenda = precoVenda;
        setDataVal(); // Definindo a data de validade automaticamente
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataFab() {
        return dataFab;
    }

    public void setDataFab(Date dataFab) {
        this.dataFab = dataFab;
        setDataVal(); // Atualiza a data de validade quando a data de fabricação é definida
    }

    public Date getDataVal() {
        return dataVal;
    }

    private void setDataVal() {
        if (dataFab != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dataFab);
            calendar.add(Calendar.MONTH, 1);
            dataVal = calendar.getTime();
        }
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }
}

public class Produto {
    public static void main(String[] args) {
        // Inicializar a data de fabricação com um valor válido
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.JUNE, 03); // Exemplo: 25 de setembro de 2024
        Date dataFab = calendar.getTime();

        CadastroProduto cadastroProd = new CadastroProduto("Pepsi", dataFab, 5.99);

        // Exibir os dados
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Nome do produto: " + cadastroProd.getNome());
        System.out.println("Data de fabricação: " + sdf.format(cadastroProd.getDataFab()));
        System.out.println("Data de validade: " + sdf.format(cadastroProd.getDataVal()));
        System.out.println("Preço de venda: " + cadastroProd.getPrecoVenda());
    }
}
