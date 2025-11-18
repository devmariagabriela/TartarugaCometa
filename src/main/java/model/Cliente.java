package model;

public class Cliente{
    private int id;
    private String tipoPessoa;
    private String cpfCnpj;
    private String nomeRazaoSocial;
    private Endereco endereco;

    public Cliente() {
    }
        public Cliente(int id, String tipoPessoa, String cpfCnpj, String nomeRazaoSocial, Endereco endereco){
            this.id = id;
            this.tipoPessoa = tipoPessoa;
            this.cpfCnpj = cpfCnpj;
            this.nomeRazaoSocial = nomeRazaoSocial;
            this.endereco = endereco;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getTipoPessoa() {
            return tipoPessoa;
        }
        public void setTipoPessoa (String tipoPessoa) {
          this.tipoPessoa = tipoPessoa;
        }
       public String getCpfCnpj() {
         return cpfCnpj;
       }
       public void setCpfCnpj(String cpfCnpj) {
           this.cpfCnpj = cpfCnpj;
       }
       public String getNomeRazaoSocial() {
           return  nomeRazaoSocial;
       }
       public void setNomeRazaoSocial(String nomeRazaoSocial) {
           this.nomeRazaoSocial = nomeRazaoSocial;
       }
       public Endereco getEndereco() {
           return endereco;
       }
       public void setEndereco(Endereco endereco) {
           this.endereco = endereco;
  }
}