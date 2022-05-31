package CRUD_USUARIO.Entidade;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 *
 * @author maste
 */
public class Usuario {
    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    private String cpf;
    private String email;
    private String senha;
    private String sexo;
    private Date dataregistro;

    /**
     * @return the dataregistro
     */
    public Date getDataregistro() {
        return dataregistro;
    }

    /**
     * @param dataregistro the dataregistro to set
     */
    public void setDataregistro(Date dataregistro) {
        this.dataregistro = dataregistro;
    }
}
