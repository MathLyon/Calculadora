
package calculadora;

import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


    @Entity
public class Calcles {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double firstN;
    private double secondN;
    private String operator;
    private double result;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getFirstN() {
        return firstN;
    }

    public void setFirstN(double firstN) {
        this.firstN = firstN;
    }

    public double getSecondN() {
        return secondN;
    }

    public void setSecondN(double secondN) {
        this.secondN = secondN;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
    public String toString() {
        return this.operator;
    }
}
